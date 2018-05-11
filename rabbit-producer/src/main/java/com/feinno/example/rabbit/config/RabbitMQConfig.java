package com.feinno.example.rabbit.config;

import com.rabbitmq.client.ConnectionFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @author liyang
 * @version 1.0
 * date 2018/5/11上午11:42
 */
@Configuration
@ComponentScan(basePackages = {"com.feinno.example.rabbit"})
@PropertySource(value = {"classpath:application.properties"})
public class RabbitMQConfig {

    @Autowired
    private Environment environment;

    @Bean
    public ConnectionFactory connectionFactory() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(environment.getProperty("mq.host").trim());
        factory.setPort(Integer.parseInt(environment.getProperty("mq.port").trim()));
        factory.setUsername(environment.getProperty("mq.username").trim());
        factory.setPassword(environment.getProperty("mq.password").trim());
        factory.setVirtualHost(environment.getProperty("mq.vhost").trim());
        return factory;
    }

    @Bean
    public CachingConnectionFactory cachingConnectionFactory() {
        return new CachingConnectionFactory(connectionFactory());
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(cachingConnectionFactory());
        template.setChannelTransacted(true);
        return template;
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(cachingConnectionFactory());
    }

    @Bean
    Queue queue() {
        String name = environment.getProperty("mq.queue");

        boolean durable = StringUtils.isNotBlank(environment.getProperty("mq.queue.durable").trim()) ? Boolean.valueOf(environment.getProperty("mq.queue.durable").trim()) : true;
        boolean exclusive = StringUtils.isNotBlank(environment.getProperty("mq.queue.exclusive").trim()) ? Boolean.valueOf(environment.getProperty("mq.queue.exclusive").trim()) : false;
        boolean autoDelete = StringUtils.isNotBlank(environment.getProperty("mq.queue.autoDelete").trim()) ? Boolean.valueOf(environment.getProperty("mq.queue.autoDelete").trim()) : false;

        return new Queue(name, durable, exclusive, autoDelete);
    }

    @Bean
    TopicExchange exchange() {
        String name = environment.getProperty("mq.exchange").trim();
        boolean durable = StringUtils.isNotBlank(environment.getProperty("mq.exchange.durable").trim()) ?
                Boolean.valueOf(environment.getProperty("mq.exchange.durable").trim()) : true;
        // 当所有消费客户端连接断开后，是否自动删除队列
        boolean autoDelete = StringUtils.isNotBlank(environment.getProperty("mq.exchange.autoDelete").trim()) ?
                Boolean.valueOf(environment.getProperty("mq.exchange.autoDelete").trim()) : false;
        return new TopicExchange(name, durable, autoDelete);
    }

    @Bean
    Binding bind() {
        String routeKey = environment.getProperty("mq.routekey").trim();
        return BindingBuilder.bind(queue()).to(exchange()).with(routeKey);
    }


}