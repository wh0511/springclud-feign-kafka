package com.feinno.example.controller;

import com.feinno.example.service.HelloService;
import com.feinno.example.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class RedisController {

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "/redis", method = RequestMethod.GET)
    public String hello() {
        return redisService.test();
    }
}