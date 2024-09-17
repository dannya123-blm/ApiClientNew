import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

/**
 * Date: 15/09/2024
 * Date: ApiClientNew
 *
 * @author Daniel Aigbe
 * @version 1
 */
public class JacksonParser {
    public static void main(String[] args) {
        try {
            // Create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Parse JSON file into List of Post objects
            List<Post> posts = objectMapper.readValue(new File("src/main/java/t.txt"), new TypeReference<List<Post>>() {});

            // Print all post titles
            for (Post post : posts) {
                System.out.println(post.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

