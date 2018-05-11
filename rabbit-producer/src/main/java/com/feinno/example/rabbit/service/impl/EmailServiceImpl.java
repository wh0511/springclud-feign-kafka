package com.feinno.example.rabbit.service.impl;

import com.feinno.example.rabbit.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author liyang
 * @version 1.0
 * date 2018/5/11上午11:59
 */
@Service
public class EmailServiceImpl implements EmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${mq.exchange}")
    private String exchange;

    @Value("${mq.routekey}")
    private String routeKey;

    @Override
    public void sendEmail(String message) throws Exception {

        try {
            rabbitTemplate.convertAndSend(exchange, routeKey, message);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

    }
}