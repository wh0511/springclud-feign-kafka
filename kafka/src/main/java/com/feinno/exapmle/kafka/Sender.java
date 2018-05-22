package com.feinno.exapmle.kafka;
import java.util.Date;

import java.util.UUID;

import com.feinno.exapmle.kafka.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
        System.out.println("kafkaTemplate's value is : " + kafkaTemplate + "gson's value : ");
        kafkaTemplate.send("perftrace", gson.toJson(m));
    }

    public void sendMsg(String msg){
        kafkaTemplate.send("perftrace", msg);
    }

}
