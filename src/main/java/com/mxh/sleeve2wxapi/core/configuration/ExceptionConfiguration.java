package com.mxh.sleeve2wxapi.core.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Map;

//指定文件
@PropertySource("classpath:config/Exception-code.properties")
//配置前缀
@ConfigurationProperties(prefix = "mxh")
@Component
@Getter
@Setter
public class ExceptionConfiguration {
//    codes和属性的codes对应所以不用多写
    private Map<Integer, String> codes;

    public String getMessage(Integer code) {
        return this.codes.get(code);
    }
}
