package com.test.service.messagehandle.impl;

import com.alibaba.fastjson.JSONObject;
import com.test.common.constant.WxApiConstant;
import com.test.common.constant.WxResponseForm;
import com.test.common.util.RestfulClient;
import com.test.service.messagehandle.WxMessageService;
import com.test.service.tokenmanager.AccessTokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Date;

@Slf4j
@Service("wxMessageImageServiceImpl")
public class WxMessageImageServiceImpl implements WxMessageService{

    @Autowired
    @Qualifier("accessTokenServiceImpl")
    private AccessTokenService accessTokenService;
    @Override
    public String messageService(JSONObject jsonParam) {

        String mediaId = jsonParam.getString("MediaId");
        byte[] data = RestfulClient.getJson(WxApiConstant.ResourcesApi.MULTIPART_GET, byte[].class, accessTokenService.getAccessToken(), mediaId);
        String dir = "/file/"+jsonParam.getString("FromUserName");
        File dirFile = new File ("/file/"+jsonParam.getString("FromUserName"));
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        File file = new File("/file/"+jsonParam.getString("FromUserName")+"/"+jsonParam.getString("MsgId")+".jpg");
        try {
            OutputStream outputStream = new FileOutputStream(file);
            outputStream.write(data);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            log.error("openId:{},mediaId:{},保存图片异常了",jsonParam.getString("FromUserName"),mediaId);
        }
        // pK38te3OGNLSheapnnhKGTSH94yXP_57YlmBWiz-N7McspxHMW_cgU-9V_347YEG
        return WxResponseForm.imageForm(jsonParam.getString("FromUserName"),jsonParam.getString("ToUserName")
        ,new Date().getTime(),"pK38te3OGNLSheapnnhKGTSH94yXP_57YlmBWiz-N7McspxHMW_cgU-9V_347YEG");
    }
}
