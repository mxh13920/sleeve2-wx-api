package com.mxh.sleeve2wxapi.core;

import com.mxh.sleeve2wxapi.core.configuration.ExceptionConfiguration;
import com.mxh.sleeve2wxapi.exception.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@ResponseBody
public class GlobalException {

    @Autowired
    private ExceptionConfiguration configuration;

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public UnifyResponse handelGlobalException(HttpServletRequest req, Exception e) {
        String method = req.getMethod();
        String uri = req.getRequestURI();
        return new UnifyResponse(9999, "服务器异常", method + ":" + uri);
    }

    @ExceptionHandler
    public ResponseEntity<UnifyResponse> handelHttpException(HttpServletRequest req, HttpException e){
        String method = req.getMethod();
        String uri = req.getRequestURI();

        UnifyResponse unifyResponse = new UnifyResponse(e.getCode(), configuration.getMessage(e.getCode()), method + ":" + uri);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpStatus resolve = HttpStatus .resolve(e.getHttpStatusCode());
        ResponseEntity<UnifyResponse> responseEntity =new ResponseEntity<>(unifyResponse,httpHeaders,resolve);
        return responseEntity;
    }


}
