import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.model.BookBody;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kkiran on 2/9/18.
 */
public class BookBodyTest {

    @Test
    public void BodyTester() throws Exception{
        String newBookStreamRecord = "{\"name\":\"BookName\",\"author\":\"SampleAuthor\",\"publishDate\":\"10/10/2018\",\"genre\":\"SampleGenre\",\"price\":200}";
        ObjectMapper objectMapper = new ObjectMapper();
        BookBody book = objectMapper.readValue(newBookStreamRecord, BookBody.class);
        Assert.assertEquals(book.getName(), "BookName");

        String deleteBookRecord = "{\"id\": 100}";
        BookBody deleteBook = objectMapper.readValue(deleteBookRecord, BookBody.class);
        Assert.assertEquals(deleteBook.getId(), 100);
    }

}
