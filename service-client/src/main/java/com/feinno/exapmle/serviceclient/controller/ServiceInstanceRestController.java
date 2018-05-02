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

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping(value = "/add")
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        List<ServiceInstance> instances = discoveryClient.getInstances("compute-service");
        Integer r = a + b;
        for (ServiceInstance instance : instances) {
            logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        }
        return r;
    }

}