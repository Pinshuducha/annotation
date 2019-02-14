package com.annotation.core.service.impl;

import com.annotation.annotationImpl.WoToken;
import com.annotation.core.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    @WoToken(" bad boy")
    public String getParam(String name) {
        return name;
    }
}
