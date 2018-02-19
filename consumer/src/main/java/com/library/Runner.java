package com.library;

import com.library.consumer.AddCustomerConsumer;
import com.library.consumer.DeleteBookConsumer;
import com.library.consumer.DeleteCustomerConsumer;
import com.library.consumer.NewBookConsumer;
import java.io.IOException;

/**
 * Created by kkiran on 2/12/18.
 */
public class Runner {

    public static void main(String[] args) throws IOException{

        String consumerType = args[0];
        switch(consumerType) {
            case "newBook": NewBookConsumer nb = new NewBookConsumer("testGroupA", "newBook");
                break;
            case "deleteBook": DeleteBookConsumer db = new DeleteBookConsumer("testGroupA", "deleteBook");
                break;
            case "newCustomer": AddCustomerConsumer ac = new AddCustomerConsumer("testGroupA", "newCustomer");
                break;
            case "deleteCustomer": DeleteCustomerConsumer dc = new DeleteCustomerConsumer("testGroupA", "deleteCustomer");
                break;
            default:
                System.out.println("INVALID CONSUMER TYPE SPECIFIED");
                break;
        }

    }

}
