package com.einstein.api.configuration;

import com.einstein.api.model.EinsteinProducer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class EinsteinConfigration {

    @Bean
    EinsteinProducer einsteinProducer(@Value("${kafka.brokerList}") String brokerList) {
        return new EinsteinProducer(producer(brokerList));
    }

    Producer<String, String> producer(String brokerList) {
        // TODO Move out to application properties file
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "client_id_test");

        // TODO Will need to update these once we know the schema of the data in the request
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return new KafkaProducer<>(props);
    }

}
