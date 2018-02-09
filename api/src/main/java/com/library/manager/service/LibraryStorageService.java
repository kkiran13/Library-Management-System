package com.library.manager.service;

import com.library.manager.config.storage.DataSinkConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by kkiran on 2/5/18.
 */
@Component
public class LibraryStorageService {

    @Autowired
    private DataSinkConfig dataSinkConfig;

    /**
     * Service method to add a new book to inventory
     * @param message Request body that needs to be sent to storage sink
     */
    public void addBook(String message) {
        dataSinkConfig.addBook(message);
    }


}
