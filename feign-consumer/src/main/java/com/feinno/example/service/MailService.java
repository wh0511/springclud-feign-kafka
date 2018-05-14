package com.feinno.example.service;

import com.alibaba.fastjson.JSONObject;
import com.feinno.example.service.impl.HelloServiceFailtureImpl;
import com.feinno.example.service.impl.MailServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author liyang
 * @version 1.0
 * date 2018/5/11下午1:48
 */
@FeignClient(value = "RABBIT-PRODUCER", fallback = MailServiceImpl.class)
public interface MailService {
    @RequestMapping(value = "/v1/send", method = RequestMethod.POST)
    JSONObject send(JSONObject jsonObject);
}