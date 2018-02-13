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

    public void bookAction(String action, String message) {
        dataSinkConfig.bookAction(action, message);
    }

    public void customerAction(String action, String message) {
        dataSinkConfig.customerAction(action, message);
    }

}
