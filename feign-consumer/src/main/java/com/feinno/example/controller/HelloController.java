package com.feinno.example.controller;

import com.feinno.example.service.HelloService;
import com.feinno.example.service.kafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;

    @Autowired
    private kafkaService kafkaService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return helloService.sayHello();
    }

    @RequestMapping(value = "/kafka", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> kafka(@RequestParam("msg") String msg) {
        //System.out.println("*(*(&(*(&*&*(*&(*&");
        return kafkaService.kafka(msg);
    }
}