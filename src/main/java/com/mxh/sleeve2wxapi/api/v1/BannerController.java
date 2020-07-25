package com.mxh.sleeve2wxapi.api.v1;

import com.mxh.sleeve2wxapi.exception.http.ForbiddenException;
import com.mxh.sleeve2wxapi.exception.http.NotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/banner")
public class BannerController {

    @GetMapping
    public String test(){
        throw new ForbiddenException(10001);
//        return "123";
    }

}
