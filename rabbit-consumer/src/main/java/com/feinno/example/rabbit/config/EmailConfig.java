package com.feinno.example.rabbit.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;


/**
 * @author liyang
 * @version 1.0
 * date 2018/5/11上午10:51
 */
@Configuration
@PropertySource(value = {"classpath:mail.properties"})
@ComponentScan(basePackages = {"com.feinno.example.rabbit"})
public class EmailConfig {

    @Autowired
    private Environment environment;


    @Bean(name = "mailSender")
    public JavaMailSender mailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(environment.getProperty("mail.host").trim());
        mailSender.setPort(Integer.parseInt(environment.getProperty("mail.port").trim()));
        mailSender.setUsername(environment.getProperty("mail.username"));
        mailSender.setPassword(environment.getProperty("mail.password"));
        mailSender.setDefaultEncoding("UTF-8");

        Properties props = new Properties();
        props.put("mail.stmp.auth", "true");
        props.put("mail.stmp.timeout", "25000");
        props.put("mail.smtp.starttls.enable", "true");
        mailSender.setJavaMailProperties(props);
        return mailSender;
    }
}