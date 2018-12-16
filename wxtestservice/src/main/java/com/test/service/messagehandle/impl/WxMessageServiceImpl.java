package com.test.service.messagehandle.impl;

import com.alibaba.fastjson.JSONObject;
import com.test.common.constant.WxResponseForm;
import com.test.service.messagehandle.WxMessageService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class WxMessageServiceImpl implements WxMessageService {

    private Map<String, WxMessageService> mapMessage = new HashMap<>();

    @PostConstruct
    private void init() {
    }
    @Override
    public String messageService(JSONObject JsonParam) {
        return mapMessage.get(JsonParam.getString("MsgType")).messageService(JsonParam);
    }
}
