package com.library;

import com.library.consumer.DeleteBookConsumer;

import java.io.IOException;

/**
 * Created by kkiran on 2/15/18.
 */
public class DeleteBookRunner {
    public static void main(String[] args) throws IOException {
        DeleteBookConsumer db = new DeleteBookConsumer("testGroupA", "deleteBook");
    }
}
