package com.test.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.test.constant.WxSubscribeBaseConstant;
import com.test.service.WxEventService;
import com.test.service.WxMessageService;
import com.test.service.WxRouteService;
import com.test.vo.WxReqParamVo;
import com.test.wxRaw.AesException;
import com.test.wxRaw.WXBizMsgCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.test.util.XmlUtil.xmlToJsonObj;

@Service
public class WxRouteServiceImpl implements WxRouteService {
    @Autowired
    private WxEventService wxEventService;

    @Autowired
    private WxMessageService wxMessageService;

    @Override
    public String preRoute(WxReqParamVo wxReqParamVo) {
        if (wxReqParamVo.getEchostr() != null) {
            // 校验签名
            return wxReqParamVo.getEchostr();
        }
        WXBizMsgCrypt pc = null;
        if ("aes".equals(wxReqParamVo.getEncryptType())) {
            try {
                pc = new WXBizMsgCrypt(WxSubscribeBaseConstant.token, WxSubscribeBaseConstant.encodingAesKey, WxSubscribeBaseConstant.appId);
                String result2 = pc.decryptMsg(wxReqParamVo.getMsgSignature(), wxReqParamVo.getTimestamp(), wxReqParamVo.getNonce(), wxReqParamVo.getBody());
                wxReqParamVo.setBody(result2);
            } catch (AesException e) {
                e.printStackTrace();
                return "success";
            }
        }
        JSONObject paramMap = xmlToJsonObj(wxReqParamVo.getBody());
        String res = "success";
        try {
            res = route(paramMap);
        } catch (Exception e) {
            e.printStackTrace();
            return res;
        }
        if ("aes".equals(wxReqParamVo.getEncryptType())) {
            try {
                // res = pc.encryptMsg(res,String.valueOf(System.currentTimeMillis()), wxReqParamVo.getNonce());
            } catch (Exception e) {
                e.printStackTrace();
                return "success";
            }
        }
        return res;
    }

    @Override
    public String route(JSONObject param) {
        // 事件
        if (WxSubscribeBaseConstant.EVENT.equals(param.get("MsgType"))) {
            return wxEventService.eventService(param);
        }
        // 消息
        return wxMessageService.messageService(param);
    }
}
