package com.test.constant;

public class WxResponseForm {
    private static final String text_res = "<xml>" +
            "<ToUserName><![CDATA[%s]]></ToUserName>" +
            "<FromUserName><![CDATA[%s]]></FromUserName>" +
            "<CreateTime>%s</CreateTime>" +
            "<MsgType><![CDATA[text]]></MsgType>" +
            "<Content><![CDATA[%s]]></Content>" +
            "</xml>";
    public static String MsgFormText(String ToUserName, String FromUserName, Long CreateTime, String Content) {
        return String.format(text_res,ToUserName,FromUserName,CreateTime,Content);
    }
}
