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



import org.apache.kafka.clients.producer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author wanghang
 * @version 1.0
 * @date 2018/5/11 0011下午 15:57
 */
@RestController
public class KafkaController {

    private static final Logger logger = LoggerFactory.getLogger(KafkaController.class);

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @RequestMapping(value = "/kafka", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> sendKafka(@RequestParam("msg") String msg) {
        Map<String, Object> map = new HashMap<>();
        try {
            String message = msg;
            //String message = "this is a message for test";
            logger.info("kafka的消息={}", message);
            //kafkaTemplate.send("perftrace",  message);
            logger.info("发送kafka成功.");
            map.put("200",message);
            //源生方式发送消息
            sendMsg();
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("发送kafka失败", e);
            map.put("500",e);
            return new ResponseEntity<>(map, HttpStatus.EXPECTATION_FAILED);
        }
    }

    //利用源生kafka发送消息(类org.apache.kafka.clients.producer.KafkaProducer)
    private void sendMsg(){
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.156.101:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 100; i++)
            producer.send(new ProducerRecord<String, String>("perftrace", Integer.toString(i), Integer.toString(i)),new Callback() {
                // 回调函数
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                    if (null != exception) {
                        logger.error(" Kafka Produce send message error " + exception);
                        //logger.error(" Kafka Produce send message info: metadata: " + JSON.toJSONString(metadata));
                        //throw new TengException(SEND_MESSAGE_FAILED_NUM, SEND_MESSAGE_FAILED_MESSAGE + exception.getMessage());
                    }
                }
            });

        producer.close();
    }

//    @RequestMapping(value = "/kafka1",method = RequestMethod.GET)
//    public String kafka(){
//        Sender sender = new Sender();
//        sender.sendMessage();
//        logger.info("kafka send msg by bean : " + sender);
//        return "hello kafka!";
//    }
}
