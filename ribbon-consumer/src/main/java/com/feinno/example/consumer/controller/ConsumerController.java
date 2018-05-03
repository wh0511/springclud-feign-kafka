/*
 * Copyright(C) 2017-2018 Feinno Tech.ALL Rights Reserved.
 * FileName: ConsumerController
 * Description: xxxxx
 * History:
 * 版本号    作者    日期    操作
 * 1.0    liyang 2018/5/2   x
 * ...
 */
package com.feinno.example.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author liyang
 * @version 1.0
 * date 2018/5/2下午5:26
 */
@RestController
public class ConsumerController {
    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "serviceFailure")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloController() {
        return restTemplate.getForEntity("http://SERVICE-CLIENT/hello", String.class).getBody();
    }

    public String serviceFailure() {
        return "Hello service is not available";
    }
}