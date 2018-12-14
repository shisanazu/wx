package com.test.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.test.constant.WxResponseForm;
import com.test.service.WxEventService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class WxEventServiceImpl implements WxEventService {

    private Map<String, WxEventService> mapEvent = new HashMap<>();

    @PostConstruct
    private void init() {
        mapEvent.put("CLICK", new WxEventService() {
            @Override
            public String eventService(JSONObject param) {
                String resMsg = param.getString("EventKey");
                return WxResponseForm.MsgFormText(param.getString("FromUserName"),param.getString("ToUserName"),System.currentTimeMillis(),resMsg);
            }
        });
    }
    @Override
    public String eventService(JSONObject param) {
        return mapEvent.get(param.getString("Event")).eventService(param);
    }
}
