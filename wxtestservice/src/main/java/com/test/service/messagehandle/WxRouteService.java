package com.test.service.messagehandle;

import com.alibaba.fastjson.JSONObject;
import com.test.common.vo.WxReqParamVo;

public interface WxRouteService {
    String preRoute(WxReqParamVo wxReqParamVo);
    String route(JSONObject param);
}
