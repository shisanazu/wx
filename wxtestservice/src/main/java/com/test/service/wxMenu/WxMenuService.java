package com.test.service.wxMenu;

import com.alibaba.fastjson.JSONObject;
import com.test.common.vo.ResCommon;

public interface WxMenuService {
    public ResCommon<JSONObject> updateMenu();
}
