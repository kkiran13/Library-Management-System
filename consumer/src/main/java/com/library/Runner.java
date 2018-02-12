package com.library;

import com.library.consumer.NewBookConsumer;
import java.io.IOException;

/**
 * Created by kkiran on 2/12/18.
 */
public class Runner {

    public static void main(String[] args) throws IOException{
        NewBookConsumer nb = new NewBookConsumer("testGroupA", "newBook");
    }

}
