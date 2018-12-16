package com.test.service.messagehandle;

import com.alibaba.fastjson.JSONObject;

public interface WxEventService {
    String eventService(JSONObject param);
}
