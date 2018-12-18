package com.test.service.tokenmanager.impl;

import com.alibaba.fastjson.JSONObject;
import com.test.common.constant.WxApiConstant;
import com.test.common.constant.WxSubscribeBaseConstant;
import com.test.common.util.RestfulClient;
import com.test.service.tokenmanager.AccessTokenService;
import com.test.service.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/12/15 0015.
 */
@Slf4j
@Service
public class AccessTokenServiceImpl implements AccessTokenService {
    public final static String ACCESS_TOKEN = "access_token";

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public String getAccessToken() {
        return (String) redisUtil.getBykey(ACCESS_TOKEN);
    }

    @Override
    public String obtainAccessToken() {
        JSONObject json = RestfulClient.getJson(WxApiConstant.BaseApi.GET_ACCESS_TOKEN, JSONObject.class, WxSubscribeBaseConstant.appId, WxSubscribeBaseConstant.appsecret);
        if (json.getString("errcode") == null) {
            String access_token = json.getString(ACCESS_TOKEN);
            Long expires_in = json.getLong("expires_in");
            redisUtil.addKey(ACCESS_TOKEN,access_token, expires_in);
            return access_token;
        } else {
            // {"errcode":40013,"errmsg":"invalid appid"}
            log.error("获取微信access_token失败了:errcode:{},errmsg:{}", json.getString("errcode"),json.getString("errmsg"));
        }
        return null;
    }
}
