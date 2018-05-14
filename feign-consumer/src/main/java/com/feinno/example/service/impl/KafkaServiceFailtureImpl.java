/*
 * Copyright(C) 2017-2018 Feinno Tech.ALL Rights Reserved.
 * FileName: HelloServiceFailtureImpl
 * Description: xxxxx
 * History:
 * 版本号    作者    日期    操作
 * 1.0    liyang 2018/5/3   x
 * ...
 */
package com.feinno.example.service.impl;

import com.feinno.example.service.kafkaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author liyang
 * @version 1.0
 * date 2018/5/3下午3:09
 */
@Component
public class KafkaServiceFailtureImpl implements kafkaService {


    @Override
    public ResponseEntity<Map<String, Object>> kafka(String msg) {
        return null;
    }
}