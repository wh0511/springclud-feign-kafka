package com.feinno.exapmle.kafka;/*
 * <p>Copyright: Copyright(C) 2017-2018</p >
 * <p> 公司：北京新媒传信科技有限公司</p >
 * FileName: ${file_name}
 * Description: xxxxx
 * History:
 * 版本号    作者    日期    操作
 * 1.0    ${user} ${date}   x
 * ...
 */
import java.util.Date;

import java.util.UUID;

import com.feinno.exapmle.kafka.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author wanghang
 * @version 1.0
 * @date 2018/5/11 0011下午 12:39
 */
@Component
public class Sender {
    @Autowired
    private KafkaTemplate kafkaTemplate;
    private Gson gson = new GsonBuilder().create();

    public void sendMessage(){
        Message m = new Message();
        m.setId(System.currentTimeMillis());
        m.setMsg(UUID.randomUUID().toString());
        m.setSendTime(new Date());
        System.out.println("kafka的模板值为 : " + kafkaTemplate + "gson的值为 : ");
        kafkaTemplate.send("perftrace", gson.toJson(m));
    }

    public void sendMsg(String msg){
        kafkaTemplate.send("perftrace", msg);
    }

}
