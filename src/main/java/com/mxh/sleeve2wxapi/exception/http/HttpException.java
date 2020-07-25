package com.mxh.sleeve2wxapi.exception.http;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HttpException extends RuntimeException{
    protected Integer code;
    protected Integer httpStatusCode;
}
