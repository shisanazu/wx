package com.test.service.tokenmanager.impl;

import com.alibaba.fastjson.JSONObject;
import com.test.common.constant.WxApiConstant;
import com.test.common.util.RestfulClient;
import com.test.service.tokenmanager.AccessTokenService;
import com.test.service.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Slf4j
@Service("jsAccessTokenServiceImpl")
public class JsAccessTokenServiceImpl implements AccessTokenService {
    public final static String ACCESS_TOKEN = "js_access_token";

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    @Qualifier("accessTokenServiceImpl")
    private AccessTokenService accessTokenService;

    @Override
    public String getAccessToken() {
        return (String) redisUtil.getBykey(ACCESS_TOKEN);
    }

    @Override
    public String obtainAccessToken() {
        JSONObject json = RestfulClient.getJson(WxApiConstant.BaseApi.GET_JS_ACCESS_TOKEN, JSONObject.class, accessTokenService.getAccessToken());
        if (json.getString("errcode").equals("0")) {
            String ticket = json.getString("ticket");
            Long expires_in = json.getLong("expires_in");
            redisUtil.addKey(ACCESS_TOKEN,ticket, expires_in);
            return ticket;
        } else {
            // {"errcode":40013,"errmsg":"invalid appid"}
            log.error("获取微信access_token失败了:errcode:{},errmsg:{}", json.getString("errcode"),json.getString("errmsg"));
        }
        return null;
    }
}
