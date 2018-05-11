package com.feinno.example.rabbit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * @author liyang
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.feinno.example.rabbit"})
public class RabbitProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitProducerApplication.class, args);
    }
}
