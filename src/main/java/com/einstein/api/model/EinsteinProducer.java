package com.einstein.api.model;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

@RequiredArgsConstructor
@Slf4j
public class EinsteinProducer {

    private final Producer<String,String> producer;

    public void sendMessage(String message){
        ProducerRecord<String, String> record = new ProducerRecord<String, String>("test",
                "This is the message " + message);
        try {
            RecordMetadata recordMetadata = producer.send(record).get();
            log.info("Topic name {}, partition {}, offset {}",
                    recordMetadata.topic(),
                    recordMetadata.partition(),
                    recordMetadata.offset());
        } catch (Exception e) {
            log.error("There was an error", e);
        }
    }
}
