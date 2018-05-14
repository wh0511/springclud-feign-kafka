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
import com.feinno.exapmle.kafka.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * @author wanghang
 * @version 1.0
 * @date 2018/5/11 0011下午 12:41
 */
//@Component
public class Receiver {
//    private Gson gson = new GsonBuilder().create();
//
//    //搞个变量接收消息
//    private String msg;
//
//    public String getMsg() {
//        return msg;
//    }
//
//    public void setMsg(String msg) {
//        this.msg = msg;
//    }
//
//    @KafkaListener(topics = "perftrace")
//    public void processMessage(String content) {
//        //赋值给msg
//        msg = content;
//        Message m = gson.fromJson(content, Message.class);
//    }
}
