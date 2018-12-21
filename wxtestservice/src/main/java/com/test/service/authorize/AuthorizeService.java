package com.test.service.authorize;

import com.alibaba.fastjson.JSONObject;

public interface AuthorizeService {

    String getOpenId(String code);
    JSONObject getUserInfo(String code);
}
