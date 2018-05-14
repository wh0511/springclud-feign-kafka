/*
 * Copyright(C) 2017-2018 Feinno Tech.ALL Rights Reserved.
 * FileName: HelloController
 * Description: xxxxx
 * History:
 * 版本号    作者    日期    操作
 * 1.0    liyang 2018/5/3   x
 * ...
 */
package com.feinno.example.controller;

import com.feinno.example.service.HelloService;
import com.feinno.example.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liupenggc
 * @version 1.1.0
 * date 2018/5/3上午10:44
 */

@RestController
public class RedisController {

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "/redis", method = RequestMethod.GET)
    public String hello() {
        return redisService.test();
    }
}