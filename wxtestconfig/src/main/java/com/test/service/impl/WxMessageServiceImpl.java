package com.test.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.test.constant.WxResponseForm;
import com.test.service.WxEventService;
import com.test.service.WxMessageService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class WxMessageServiceImpl implements WxMessageService {

    private Map<String, WxMessageService> mapMessage = new HashMap<>();

    @PostConstruct
    private void init() {
        mapMessage.put("text", new WxMessageService() {
            @Override
            public String messageService(JSONObject JsonParam) {
                String resMsg = JsonParam.getString("Content");
                return WxResponseForm.MsgFormText(JsonParam.getString("FromUserName"),JsonParam.getString("ToUserName"),System.currentTimeMillis(),resMsg);

            }
        });
        mapMessage.put("image", new WxMessageService() {
            @Override
            public String messageService(JSONObject JsonParam) {
                return null;
            }
        });
        mapMessage.put("voice", new WxMessageService() {
            @Override
            public String messageService(JSONObject JsonParam) {
                return null;
            }
        });
        mapMessage.put("video", new WxMessageService() {
            @Override
            public String messageService(JSONObject JsonParam) {
                return null;
            }
        });
        mapMessage.put("shortvideo", new WxMessageService() {
            @Override
            public String messageService(JSONObject JsonParam) {
                return null;
            }
        });
        mapMessage.put("location", new WxMessageService() {
            @Override
            public String messageService(JSONObject JsonParam) {
                return null;
            }
        });
        mapMessage.put("link", new WxMessageService() {
            @Override
            public String messageService(JSONObject JsonParam) {
                return null;
            }
        });
    }
    @Override
    public String messageService(JSONObject JsonParam) {
        return mapMessage.get(JsonParam.getString("MsgType")).messageService(JsonParam);
    }
}
