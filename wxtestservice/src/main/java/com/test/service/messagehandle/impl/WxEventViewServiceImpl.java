package com.test.service.messagehandle.impl;

import com.alibaba.fastjson.JSONObject;
import com.test.service.messagehandle.WxEventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("wxEventViewServiceImpl")
public class WxEventViewServiceImpl implements WxEventService {
    @Override
    public String eventService(JSONObject param) {
        return "success";
    }
}
