package com.feinno.example.rabbit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


/**
 * @author liyang
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.feinno.example.rabbit"})
@EnableDiscoveryClient
public class RabbitProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitProducerApplication.class, args);
    }
}
