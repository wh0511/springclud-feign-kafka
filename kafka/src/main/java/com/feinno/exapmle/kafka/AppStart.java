package com.feinno.exapmle.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableDiscoveryClient
@SpringBootApplication
public class AppStart {
    public static void main(String[] args) throws InterruptedException {

//        ApplicationContext app = SpringApplication.run(AppStart.class, args);
        SpringApplication.run(AppStart.class, args);

//        while(true){
//            Sender sender = app.getBean(Sender.class);
//            sender.sendMessage();
//            Thread.sleep(500);
//        }
    }
}
