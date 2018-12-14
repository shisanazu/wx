package com.test.service;

import com.alibaba.fastjson.JSONObject;
import com.test.vo.WxReqParamVo;

public interface WxRouteService {
    String preRoute(WxReqParamVo wxReqParamVo);
    String route(JSONObject param);
}
