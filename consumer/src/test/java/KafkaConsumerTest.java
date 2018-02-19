import com.library.consumer.NewBookConsumer;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by kkiran on 2/12/18.
 */
public class KafkaConsumerTest {

    NewBookConsumer newBookConsumer;

    @Test
    public void newBookConsumerTest() throws IOException{
        newBookConsumer = new NewBookConsumer("testGroupA", "newBook");
    }

}
