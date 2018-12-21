package com.test.service.h5Message.impl;

import com.alibaba.fastjson.JSONObject;
import com.test.common.constant.WxApiConstant;
import com.test.common.util.FileUtil;
import com.test.common.util.RestfulClient;
import com.test.service.h5Message.H5MessageService;
import com.test.service.tokenmanager.AccessTokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class H5MessageServiceImpl implements H5MessageService {

    @Autowired
    @Qualifier("accessTokenServiceImpl")
    private AccessTokenService accessTokenService;
    @Override
    public JSONObject service(JSONObject jsonObject) {
        String mediaId = jsonObject.getString("mediaId");
        byte[] data = RestfulClient.getJson(WxApiConstant.ResourcesApi.MULTIPART_GET, byte[].class, accessTokenService.getAccessToken(), mediaId);
        FileUtil.saveFile("/file/","xxx.jpg",data);
        return new JSONObject();
    }
}
