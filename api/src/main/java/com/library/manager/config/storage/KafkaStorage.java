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

    @Override
    public void bookAction(String action, String message) {
        switch(action) {
            case "add": kafkaTemplate.send("newBook", message);
                break;
            case "remove": kafkaTemplate.send("deleteBook", message);
                break;
            case "checkout": kafkaTemplate.send("checkoutBook", message);
                break;
            case "return": kafkaTemplate.send("returnBook", message);
                break;
            default:
                System.out.println("INVALID ACTION");
                break;
        }

    }

    @Override
    public void customerAction(String action, String message) {
        switch(action) {
            case "add": kafkaTemplate.send("newCustomer", message);
                break;
            case "remove": kafkaTemplate.send("deleteCustomer", message);
                break;
            default:
                System.out.println("INVALID ACTION");
                break;
        }
    }

}
