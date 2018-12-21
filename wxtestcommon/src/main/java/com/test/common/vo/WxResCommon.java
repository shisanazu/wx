package com.test.common.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WxResCommon {
    @JSONField(name ="errcode")
    private String errCode;
    @JSONField(name ="errmsg")
    private String errMsg;
}
