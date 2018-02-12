import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        JsonNode json = objectMapper.readValue(newBookStreamRecord, JsonNode.class);
        Assert.assertEquals(json.get("name").asText(), "BookName");
    }
}
