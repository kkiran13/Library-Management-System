import com.library.model.BookBody;
import com.library.model.CustomerBody;
import com.library.storage.MySqlStorage;
import org.junit.Before;
import org.junit.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kkiran on 2/12/18.
 */
public class HibernateTest {
    MySqlStorage mySqlStorage;

    @Before
    public void init() {
        mySqlStorage = new MySqlStorage();
    }

    @Test
    public void addBookTest(){
        BookBody book = new BookBody();
        book.setName("TestName");
        book.setPrice(100);
        book.setAuthor("TestAuthor");
        book.setGenre("TestGenre");
        String dateInString = "10-10-2013";
//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//        Date publishDate = formatter.parse(dateInString);
        book.setPublishDate(dateInString);
        mySqlStorage.newBookStorage(book);
    }

    @Test
    public void deleteBookTest(){
        BookBody book = new BookBody();
        book.setId(1);
        mySqlStorage.deleteBookStorage(book);
    }

    @Test
    public void addCustomerTest() {
        CustomerBody customerBody = new CustomerBody();
        customerBody.setFirstname("customer");
        customerBody.setLastname("one");
        customerBody.setAge(20);
        customerBody.setAddress("Address of customer 1");
        mySqlStorage.newCustomerStorage(customerBody);
    }

    @Test
    public void deleteCustomerTest(){
        CustomerBody customerBody = new CustomerBody();
        customerBody.setId(1);
        mySqlStorage.deleteCustomerStorage(customerBody);
    }

}
