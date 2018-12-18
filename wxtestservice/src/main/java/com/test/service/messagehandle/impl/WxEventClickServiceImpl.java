package com.test.service.messagehandle.impl;

import com.alibaba.fastjson.JSONObject;
import com.test.common.constant.WxResponseForm;
import com.test.service.messagehandle.WxEventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("wxEventClickServiceImpl")
public class WxEventClickServiceImpl implements WxEventService{
    @Override
    public String eventService(JSONObject param) {
        return WxResponseForm.MsgFormText(param.getString("FromUserName"),param.getString("ToUserName"),System.currentTimeMillis(),
                "你点击按钮");
    }
}
