/*
 * Copyright(C) 2017-2018 Feinno Tech.ALL Rights Reserved.
 * FileName: ServiceInstanceRestController
 * Description: xxxxx
 * History:
 * 版本号    作者    日期    操作
 * 1.0    liyang 2018/5/2   x
 * ...
 */
package com.feinno.exapmle.serviceclient.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liyang
 * @version 1.0
 * date 2018/5/2下午3:10
 */
@RestController
public class ServiceInstanceRestController {
    private static final Logger logger = LoggerFactory.getLogger(ServiceInstanceRestController.class);

    @Autowired
    private DiscoveryClient discoveryClient;


    @RequestMapping(value = "/hello")
    public String index() {
        List<ServiceInstance> instances = discoveryClient.getInstances("hello-service");
        for (ServiceInstance instance : instances) {
            logger.info("/hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
        }
        return "Hello World";
    }

}