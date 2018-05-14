/*
 * <p>Copyright: Copyright(C) 2017-2018</p >
 * <p> 公司：北京新媒传信科技有限公司</p >
 * FileName: ${file_name}
 * Description: xxxxx
 * History:
 * 版本号    作者    日期    操作
 * 1.0    ${user} ${date}   x
 * ...
 */
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
//        //logger.info("kafka的key: " + record.key());
//        logger.info("kafka的value: " + record.value().toString());
//    }
}
