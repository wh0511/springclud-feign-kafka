package com.feinno.example.rabbit.controller;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;
import com.feinno.example.rabbit.service.EmailService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liyang
 * @version 1.0
 * date 2018/5/11下午12:03
 */
@RestController
@RequestMapping(value = "/v1/send")
public class EmailController {

    @Resource
    private EmailService emailService;

    /**
     * json结构体
     * {
     *   "to":"liyangsj@feinno.com",
     *   "subject":"测试Rabbit",
     *   "text":"<html><head></head><body><h1>邮件测试</h1><p>hello!this is mail test。</p></body></html>"}
     *
     *   eg:
     *   curl -X "POST" "http://localhost:4041/v1/send" \
     *      -H 'Content-Type: application/json; charset=utf-8' \
     *      -d $'{
     *   "to": "liyangsj@feinno.com",
     *   "subject": "测试Rabbit",
     *   "text": "<html><head></head><body><h1>邮件测试</h1><p>hello!this is mail test。</p></body></html>"
     * }'
     */
    @RequestMapping(method = RequestMethod.POST)
    public JSONObject add(@RequestBody JSONObject jsonObject) throws Exception {
        emailService.sendEmail(jsonObject.toJSONString());
        return jsonObject;
    }
}