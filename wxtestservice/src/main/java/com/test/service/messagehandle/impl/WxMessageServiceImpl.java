package com.test.service.messagehandle.impl;

import com.alibaba.fastjson.JSONObject;
import com.test.common.constant.WxResponseForm;
import com.test.service.messagehandle.WxMessageService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service("wxMessageServiceImpl")
public class WxMessageServiceImpl implements WxMessageService {

    public Map<String, WxMessageService> mapMessage = new HashMap<>();

    @Override
    public String messageService(JSONObject JsonParam) {
        if ( mapMessage.get(JsonParam.getString("MsgType")) != null) {
            return mapMessage.get(JsonParam.getString("MsgType")).messageService(JsonParam);
        } else {
            return null;
        }
    }
}
