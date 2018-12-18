package com.test.service.config;


import com.test.service.messagehandle.WxEventService;
import com.test.service.messagehandle.WxMessageService;
import com.test.service.messagehandle.impl.WxEventServiceImpl;
import com.test.service.messagehandle.impl.WxMessageServiceImpl;
import com.test.service.util.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

@Slf4j
@Component
public class InitService implements ApplicationRunner {

    @Autowired
    private BeanUtil beanUtil;

    @Autowired
    @Qualifier("wxMessageServiceImpl")
    private WxMessageService wxMessageService;

    @Autowired
    @Qualifier("wxEventServiceImpl")
    private WxEventService wxEventService;

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 初始化消息处理类
        Map<String, WxMessageService> map = beanUtil.getBean(WxMessageService.class);
        WxMessageServiceImpl wx = (WxMessageServiceImpl) wxMessageService;
        for (Map.Entry<String, WxMessageService> per : map.entrySet()) {
            String key = per.getKey();
            String msgType = key.substring(9,key.indexOf("ServiceImpl"));
            wx.mapMessage.put(msgType.toLowerCase(),per.getValue());
        }

        StringRedisSerializer var1 = new StringRedisSerializer();
        redisTemplate.setKeySerializer(var1);
        redisTemplate.setValueSerializer(var1);
        log.info("-------------->");

        // 初始化事件处理类
        WxEventServiceImpl var3 = (WxEventServiceImpl) wxEventService;
        Map<String, WxEventService> mapEvent = beanUtil.getBean(WxEventService.class);
        for (Map.Entry<String, WxEventService> per : mapEvent.entrySet()) {
            String key = per.getKey();
            String msgType = key.substring(7,key.indexOf("ServiceImpl"));
            if (msgType.equals("Subscribe") || msgType.equals("Unsubscribe")) {
                var3.mapEvent.put(msgType.toLowerCase(),per.getValue());
            } else {
                var3.mapEvent.put(msgType.toUpperCase(),per.getValue());
            }
        }
    }
}
