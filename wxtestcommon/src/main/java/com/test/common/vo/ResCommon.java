package com.test.common.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResCommon<T> {
    private String resCode;
    private String resMsg;
    private T data;
}
