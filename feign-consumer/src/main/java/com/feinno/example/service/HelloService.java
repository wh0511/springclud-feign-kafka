package com.feinno.example.service;

import com.feinno.example.service.impl.HelloServiceFailtureImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


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