package com.feinno.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.feinno.example.service.MailService;
import org.springframework.stereotype.Component;

/**
 * @author liyang
 * @version 1.0
 * date 2018/5/11下午1:50
 */
@Component
public class MailServiceImpl implements MailService {
    @Override
    public JSONObject send(JSONObject jsonObject) {
        System.out.println("the service is not available;" + jsonObject.toJSONString());
        return jsonObject;
    }
}