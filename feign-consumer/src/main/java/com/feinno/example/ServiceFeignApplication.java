/*
 * Copyright(C) 2017-2018 Feinno Tech.ALL Rights Reserved.
 * FileName: ServiceFeignApplication
 * Description: xxxxx
 * History:
 * 版本号    作者    日期    操作
 * 1.0    liyang 2018/5/3   x
 * ...
 */
package com.feinno.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;


/**
 * @author liyang
 * @version 1.0
 * date 2018/5/3上午10:32
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
public class ServiceFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceFeignApplication.class, args);
    }


//    @Bean
//    @Scope("prototype")
//    public Feign.Builder feignBuilder() {
//        return Feign.builder();
//    }
}
