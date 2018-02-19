package com.library.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.model.CustomerBody;
import com.library.storage.MySqlStorage;
import com.library.utils.ConsumerInit;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.IOException;

/**
 * Created by kkiran on 2/16/18.
 */
public class AddCustomerConsumer {

    private static ObjectMapper objectMapper;
    private static MySqlStorage mySqlStorage;
    private static ConsumerInit consumerInit;
    private static KafkaConsumer<String, String> kafkaConsumer;

    public AddCustomerConsumer(String groupName, String streamName) throws IOException {
        objectMapper = new ObjectMapper();
        mySqlStorage = new MySqlStorage();
        consumerInit = new ConsumerInit();
        kafkaConsumer = consumerInit.streamInit(groupName, streamName);
        addCustomerStreamProcessor();
    }

    private void addCustomerStreamProcessor() throws IOException{
        while (true) {
            ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                CustomerBody customerBody = objectMapper.readValue(record.value(), CustomerBody.class);
                mySqlStorage.newCustomerStorage(customerBody);
            }
        }
    }

}
