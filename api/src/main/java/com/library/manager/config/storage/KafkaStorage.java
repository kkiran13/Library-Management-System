package com.library.manager.config.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by kkiran on 2/9/18.
 */
@Component
@Profile("storage.kafka")
public class KafkaStorage implements DataSinkConfig{

    @Autowired
    private KafkaTemplate kafkaTemplate;

    /***
     * Method that posts message to kafka
     * @param message request body
     */
    @Override
    public void addBook(String message) {
        kafkaTemplate.send("newBook", message);
    }

}
