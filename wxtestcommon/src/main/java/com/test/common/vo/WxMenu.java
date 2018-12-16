package com.test.common.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WxMenu {
    private String button; // 是	一级菜单数组，个数应为1~3个
    @JSONField(name = "sub_button")
    private String subButton; // 否	二级菜单数组，个数应为1~5个
    private String type; // 是	菜单的响应动作类型，view表示网页类型，click表示点击类型，miniprogram表示小程序类型
    private String name; // 是	菜单标题，不超过16个字节，子菜单不超过60个字节
    private String key; // click等点击类型必须	菜单KEY值，用于消息接口推送，不超过128字节
    private String url; // view、miniprogram类型必须	网页 链接，用户点击菜单可打开链接，不超过1024字节。 type为miniprogram时，
    @JSONField(name = "media_id")
    private String mediaId; // edia_id类型和view_limited类型必须	调用新增永久素材接口返回的合法media_id
    @JSONField(name = "appid")
    private String appId; // miniprogram类型必须	小程序的appid（仅认证公众号可配置）
    @JSONField(name = "pagepath")
    private String pagePath; // miniprogram类型必须	小程序的页面路径
}
