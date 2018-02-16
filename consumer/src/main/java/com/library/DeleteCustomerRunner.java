package com.library;

import com.library.consumer.DeleteCustomerConsumer;

import java.io.IOException;

/**
 * Created by kkiran on 2/16/18.
 */
public class DeleteCustomerRunner {

    public static void main(String[] args) throws IOException {
        DeleteCustomerConsumer dc = new DeleteCustomerConsumer("testGroupA", "deleteCustomer");
    }

}
