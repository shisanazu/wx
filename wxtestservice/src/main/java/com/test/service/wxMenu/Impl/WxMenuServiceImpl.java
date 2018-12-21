package com.test.service.wxMenu.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.test.common.constant.WxApiConstant;
import com.test.common.dao.wxmenu.WxButtonMapper;
import com.test.common.model.wxmenu.WxButton;
import com.test.common.util.RestfulClient;
import com.test.common.vo.ResCommon;
import com.test.common.vo.WxResCommon;
import com.test.service.tokenmanager.AccessTokenService;
import com.test.service.wxMenu.WxMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class WxMenuServiceImpl implements WxMenuService {

    @Autowired
    @Qualifier("accessTokenServiceImpl")
    private AccessTokenService accessTokenService;

    @Autowired
    private WxButtonMapper wxButtonMapper;

    private  List<WxButton> getSub(Integer id, List<WxButton> list) {
        List<WxButton> result = new ArrayList<>();
        for(WxButton WxButton : list) {
            if (WxButton.getParentId().equals(id)) {
                result.add(WxButton);
            }
        }
        return result;
    }
    private JSONObject assembleMenu(List<WxButton> list) {
        JSONObject buttonWap = new JSONObject();
        JSONArray arry = new JSONArray();
        list.stream().forEach((a)->{
            if (a.getParentId().equals(0)) {
                JSONObject button = JSONObject.parseObject(JSONObject.toJSONString(a));
                List<WxButton> listSub = getSub(a.getId(), list);
                if (listSub.size() > 0) {
                    button.put("sub_button", listSub);
                }
                arry.add(button);
            }
        });
        buttonWap.put("button", arry);
        return buttonWap;
    }
    @Override
    public ResCommon<JSONObject> updateMenu() {
        List<WxButton> list = wxButtonMapper.find(new WxButton());
        String token = accessTokenService.getAccessToken();
        ResCommon<JSONObject> resCommon = new ResCommon<>();
        // 先行删除原来的按钮 然后在添加
        String resStr = RestfulClient.getJson(WxApiConstant.MenuApi.DELETE_MENU, String.class, token);
        WxResCommon res = JSONObject.parseObject(resStr, WxResCommon.class);
        if (res.getErrCode().equals("0")) {
            JSONObject param = assembleMenu(list);
            String resCStr = RestfulClient.postJson(WxApiConstant.MenuApi.CREATE_MENU, String.class, JSONObject.toJSONString(param), token);
            WxResCommon resC = JSONObject.parseObject(resCStr, WxResCommon.class);
            if (resC.getErrCode().equals("0")) {
                resCommon.setResCode("000000");
                resCommon.setResMsg(res.getErrMsg());
            }
        }else {
            resCommon.setResCode("000001");
            resCommon.setResMsg(res.getErrMsg());
        }
        return resCommon;
    }
}
