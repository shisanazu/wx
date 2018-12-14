package com.test.vo;

import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class WxReqParamVo {
    private String signature;
    private String timestamp;
    private String nonce;
    private String echostr;
    private String msgSignature;
    private String encryptType;
    private String body;

    public WxReqParamVo(HttpServletRequest request) {
        signature = (String) request.getParameter("signature");
        timestamp = (String) request.getParameter("timestamp");
        nonce = (String) request.getParameter("nonce");
        echostr = (String) request.getParameter("echostr");
        msgSignature = (String) request.getParameter("msg_signature");
        encryptType = (String) request.getParameter("encrypt_type");
        try {
            body = IOUtils.toString(request.getInputStream(), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getEchostr() {
        return echostr;
    }

    public void setEchostr(String echostr) {
        this.echostr = echostr;
    }

    public String getMsgSignature() {
        return msgSignature;
    }

    public void setMsgSignature(String msgSignature) {
        this.msgSignature = msgSignature;
    }

    public String getEncryptType() {
        return encryptType;
    }

    public void setEncryptType(String encryptType) {
        this.encryptType = encryptType;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
