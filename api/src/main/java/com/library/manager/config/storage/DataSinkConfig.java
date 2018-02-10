package com.library.manager.config.storage;

/**
 * Created by kkiran on 2/9/18.
 */
public interface DataSinkConfig {

    void bookAction(String action, String message);

    void customerAction(String action, String message);

}
