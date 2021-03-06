package com.feinno.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.feinno.example.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    @Autowired
    private MailService mailService;

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public JSONObject send(@RequestBody JSONObject jsonObject) {
        mailService.send(jsonObject);
        return jsonObject;
    }
}