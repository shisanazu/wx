package com.test.service.messagehandle.impl;

import com.alibaba.fastjson.JSONObject;
import com.test.common.constant.WxResponseForm;
import com.test.service.messagehandle.WxMessageService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("wxMessageImageServiceImpl")
public class WxMessageImageServiceImpl implements WxMessageService{
    @Override
    public String messageService(JSONObject JsonParam) {
        // pK38te3OGNLSheapnnhKGTSH94yXP_57YlmBWiz-N7McspxHMW_cgU-9V_347YEG
        return WxResponseForm.imageForm(JsonParam.getString("FromUserName"),JsonParam.getString("ToUserName")
        ,new Date().getTime(),"pK38te3OGNLSheapnnhKGTSH94yXP_57YlmBWiz-N7McspxHMW_cgU-9V_347YEG");
    }
}
