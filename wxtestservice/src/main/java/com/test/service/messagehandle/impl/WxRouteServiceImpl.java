package com.test.service.messagehandle.impl;

import com.alibaba.fastjson.JSONObject;
import com.test.common.constant.WxSubscribeBaseConstant;
import com.test.common.vo.WxReqParamVo;
import com.test.common.wxraw.AesException;
import com.test.common.wxraw.WXBizMsgCrypt;
import com.test.service.messagehandle.WxEventService;
import com.test.service.messagehandle.WxMessageService;
import com.test.service.messagehandle.WxRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.test.common.util.XmlUtil.xmlToJsonObj;


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
                res = pc.encryptMsg(res,String.valueOf(System.currentTimeMillis()), wxReqParamVo.getNonce());
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
