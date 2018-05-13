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
import com.feinno.example.service.RedisService;
import org.springframework.stereotype.Component;

/**
 * @author liupenggc
 * @version 1.1.0
 * @date 2018-05-11 15:40
 */
@Component
public class RedisServiceImpl implements RedisService {

    @Override
    public String test() {
        return "the RedisService is not available";
    }
}