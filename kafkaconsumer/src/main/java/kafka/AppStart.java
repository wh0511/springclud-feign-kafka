package kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.Properties;


//@EnableDiscoveryClient
@SpringBootApplication
public class AppStart {
    public static void main(String[] args) throws InterruptedException {

        ApplicationContext app = SpringApplication.run(AppStart.class, args);
        //SpringApplication.run(AppStart.class, args);

        //
//        Properties props = new Properties();
//        props.put("bootstrap.servers", "192.168.156.101:9092");
//        props.put("group.id", "test-consumer-group");
//        props.put("enable.auto.commit", "true");
//        props.put("auto.commit.interval.ms", "1000");
//        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

        KafkaConsumerBean bean = app.getBean(KafkaConsumerBean.class);
        KafkaConsumer<String, String> consumer = bean.getBean();
        bean.getMsg(consumer);

        //consumer.subscribe(Arrays.asList("foo", "bar"));
//        while (true) {
//            ConsumerRecords<String, String> records = consumer.poll(100);
//            for (ConsumerRecord<String, String> record : records){
//                System.out.println("msg's valie is :" + record.value());
//                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
//            }
//        }

    }
}
