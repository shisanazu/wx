package com.test.service.messagehandle.impl;

import com.alibaba.fastjson.JSONObject;
import com.test.common.constant.WxApiConstant;
import com.test.common.util.RestfulClient;
import com.test.service.messagehandle.WxMessageService;
import com.test.service.tokenmanager.AccessTokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

@Slf4j
@Service
public class WxMessageVoiceServiceImpl implements WxMessageService {

    @Autowired
    @Qualifier("accessTokenServiceImpl")
    private AccessTokenService accessTokenService;
    @Override
    public String messageService(JSONObject jsonParam) {
        String mediaId = jsonParam.getString("MediaId");
        String format = jsonParam.getString("Format");
        byte[] data = RestfulClient.getJson(WxApiConstant.ResourcesApi.MULTIPART_GET, byte[].class, accessTokenService.getAccessToken(), mediaId);
        String dir = "/file/"+jsonParam.getString("FromUserName");
        File dirFile = new File ("/file/"+jsonParam.getString("FromUserName"));
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        File file = new File("/file/"+jsonParam.getString("FromUserName")+"/"+jsonParam.getString("MsgId")+"."+format);
        try {
            OutputStream outputStream = new FileOutputStream(file);
            outputStream.write(data);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            log.error("openId:{},mediaId:{},保存声音异常了",jsonParam.getString("FromUserName"),mediaId);
        }
        return "success";
    }
}
