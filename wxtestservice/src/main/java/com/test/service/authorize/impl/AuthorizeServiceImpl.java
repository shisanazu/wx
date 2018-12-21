package com.test.service.authorize.impl;

import com.alibaba.fastjson.JSONObject;
import com.test.common.constant.WxApiConstant;
import com.test.common.constant.WxSubscribeBaseConstant;
import com.test.common.util.RestfulClient;
import com.test.service.authorize.AuthorizeService;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

@Service
public class AuthorizeServiceImpl implements AuthorizeService {
    @Override
    public String getOpenId(String code) {
        JSONObject jsonObject = getAccessToken(code);
        return jsonObject.getString("openid");
    }

    @Override
    public JSONObject getUserInfo(String code) {
        JSONObject jsonObject = getAccessToken(code);
        String res = RestfulClient.getJson(WxApiConstant.AuthorizeApi.USER_INFO, String.class, jsonObject.getString("access_token"), jsonObject.getString("openid"));
        try {
            res = new String(res.getBytes("ISO8859-1"),"utf-8");
            System.out.println(res);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        JSONObject info = JSONObject.parseObject(res);
        return info;
    }
    public JSONObject getAccessToken(String code) {
        String res = RestfulClient.getJson(WxApiConstant.AuthorizeApi.GET_ACCESS_TOKEN, String.class,
                WxSubscribeBaseConstant.appId,WxSubscribeBaseConstant.appsecret,code);
        JSONObject jsonObject = JSONObject.parseObject(res);
        return jsonObject;
    }
}
