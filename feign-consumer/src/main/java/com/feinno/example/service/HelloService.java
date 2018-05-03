/*
 * Copyright(C) 2017-2018 Feinno Tech.ALL Rights Reserved.
 * FileName: HelloService
 * Description: xxxxx
 * History:
 * 版本号    作者    日期    操作
 * 1.0    liyang 2018/5/3   x
 * ...
 */
package com.feinno.example.service;

import com.feinno.example.service.impl.HelloServiceFailtureImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author liyang
 * @version 1.0
 * date 2018/5/3上午10:35
 */
@FeignClient(value = "SERVICE-CLIENT", fallback = HelloServiceFailtureImpl.class)
public interface HelloService {
    /**
     * ..
     *
     * @return
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String sayHello();
}