/*
 * Copyright(C) 2017-2018 Feinno Tech.ALL Rights Reserved.
 * FileName: HelloServiceFailtureImpl
 * Description: xxxxx
 * History:
 * 版本号    作者    日期    操作
 * 1.0    liyang 2018/5/3   x
 * ...
 */
package com.feinno.example.service.impl;

import com.feinno.example.service.HelloService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author liyang
 * @version 1.0
 * date 2018/5/3下午3:09
 */
@Component
public class HelloServiceFailtureImpl implements HelloService {
    @Override
    public String sayHello() {
        return "the service is not available";
    }
}