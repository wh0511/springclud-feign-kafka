package com.feinno.exapmle.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * @author wanghang
 * @version 1.0
 * @date 2018/5/14 0014上午 9:56
 */
public class Listener {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());


//    @KafkaListener(topics = {"perftrace"})
//    public void listen(ConsumerRecord<?, ?> record) {
//        //logger.info("kafka's key: " + record.key());
//        logger.info("kafka's value: " + record.value().toString());
//    }
}
