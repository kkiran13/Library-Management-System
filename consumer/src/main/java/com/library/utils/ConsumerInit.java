package com.library.utils;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

/**
 * Created by kkiran on 2/9/18.
 */
public class ConsumerInit {

    public KafkaConsumer streamInit(String groupName, String streamName) throws IOException{
        Properties props = new Properties();
        props.put("bootstrap.servers", "kafka:9092");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("auto.offset.reset", "earliest");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("group.id", groupName);

        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(props);
        kafkaConsumer.subscribe(Arrays.asList(streamName));
        return kafkaConsumer;
    }

}
