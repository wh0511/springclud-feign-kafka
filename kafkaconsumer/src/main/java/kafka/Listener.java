package kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class Listener {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());


//    @KafkaListener(topics = {"perftrace"})
//    public void listen(ConsumerRecord<?, ?> record) {
//        //logger.info("kafka's key: " + record.key());
//        logger.info("kafka's value: " + record.value().toString());
//    }
}
