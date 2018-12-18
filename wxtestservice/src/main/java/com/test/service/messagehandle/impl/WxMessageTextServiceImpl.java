package com.test.service.messagehandle.impl;

import com.alibaba.fastjson.JSONObject;
import com.test.common.constant.WxResponseForm;
import com.test.service.messagehandle.WxMessageService;
import org.springframework.stereotype.Service;

@Service("wxMessageTextServiceImpl")
public class WxMessageTextServiceImpl implements WxMessageService {
    @Override
    public String messageService(JSONObject JsonParam) {
        String res = "请按如下回复查询:\n" +
                "1:查询1\n" +
                "2:查询2\n" +
                "3:查询3";
        return WxResponseForm.MsgFormText(JsonParam.getString("FromUserName"),JsonParam.getString("ToUserName"),System.currentTimeMillis(),
                res);
    }
}
