package com.feinno.example.service;

import com.feinno.example.service.impl.RedisServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "redis-client",fallback = RedisServiceImpl.class)
public interface RedisService {

    @RequestMapping(value = "/redis/test", method = RequestMethod.GET)
    String test();
}
