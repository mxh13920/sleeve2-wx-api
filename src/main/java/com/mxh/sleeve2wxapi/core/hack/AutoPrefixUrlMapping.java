package com.mxh.sleeve2wxapi.core.hack;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

public class AutoPrefixUrlMapping extends RequestMappingHandlerMapping {

    @Value("${sleeve.prefix}")
    private String apiPage;

    @Override
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
        RequestMappingInfo mappingForMethod = super.getMappingForMethod(method, handlerType);
        if (mappingForMethod != null) {
            String prefix = this.getPrefix(handlerType);
            RequestMappingInfo combine = RequestMappingInfo.paths(prefix).build().combine(mappingForMethod);
            return combine;
        }
        return mappingForMethod;
    }

    public String getPrefix(Class<?> handlerType){
        String packageName = handlerType.getPackageName();
        String packge=packageName.replaceAll(this.apiPage,"");
        String name = packge.replace(".", "/");
        return name;
    }
}
