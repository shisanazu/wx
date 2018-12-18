package com.test.service.messagehandle.impl;

import com.alibaba.fastjson.JSONObject;
import com.test.common.constant.WxResponseForm;
import com.test.service.messagehandle.WxEventService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;


@Service("wxEventServiceImpl")
public class WxEventServiceImpl implements WxEventService {

    public Map<String, WxEventService> mapEvent = new HashMap<>();

    @Override
    public String eventService(JSONObject param) {
        if (param.getString("Event") != null) {
            return mapEvent.get(param.getString("Event")).eventService(param);
        } else {
            return "success";
        }
    }
}
