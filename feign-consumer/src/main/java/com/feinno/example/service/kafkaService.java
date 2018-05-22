package com.feinno.example.service;

import com.feinno.example.service.impl.KafkaServiceFailtureImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@FeignClient(value = "service-kafka", fallback = KafkaServiceFailtureImpl.class)
public interface kafkaService {


    @RequestMapping(value = "/kafka", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> kafka(@RequestParam("msg") String msg);
}
