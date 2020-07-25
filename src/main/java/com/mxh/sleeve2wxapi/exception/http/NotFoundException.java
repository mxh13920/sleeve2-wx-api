package com.mxh.sleeve2wxapi.exception.http;

public class NotFoundException extends HttpException{
    public NotFoundException(Integer code){
        this.code=code;
        this.httpStatusCode=404;
    }
}
