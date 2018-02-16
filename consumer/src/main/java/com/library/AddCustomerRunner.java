package com.library;

import com.library.consumer.AddCustomerConsumer;

import java.io.IOException;

/**
 * Created by kkiran on 2/16/18.
 */
public class AddCustomerRunner {

    public static void main(String[] args) throws IOException {
        AddCustomerConsumer ac = new AddCustomerConsumer("testGroupA", "newCustomer");
    }

}
