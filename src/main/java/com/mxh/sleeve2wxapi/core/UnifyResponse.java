package com.mxh.sleeve2wxapi.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UnifyResponse {
    private Integer code;
    private String message;
    private String request;
}
