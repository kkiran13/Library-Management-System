package com.library.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.model.BookBody;
import com.library.storage.MySqlStorage;
import com.library.utils.ConsumerInit;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import java.io.IOException;

/**
 * Created by kkiran on 2/9/18.
 */
public class NewBookConsumer {
    private static ObjectMapper objectMapper;
    private static MySqlStorage mySqlStorage;
    private static KafkaConsumer<String, String> kafkaConsumer;

    public NewBookConsumer(String groupName, String streamName) throws IOException{
        objectMapper = new ObjectMapper();
        mySqlStorage = new MySqlStorage();
        kafkaConsumer = ConsumerInit.streamInit(groupName, streamName);
        newBookStreamProcessor();
    }

    private void newBookStreamProcessor() throws IOException{
        while (true) {
            ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                BookBody book = objectMapper.readValue(record.value(), BookBody.class);
                mySqlStorage.newBookStorage(book);
            }
        }
    }

}
