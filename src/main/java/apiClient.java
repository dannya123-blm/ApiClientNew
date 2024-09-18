import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class apiClient {

    public static void main(String[] args) throws Exception {

        File file = new File("src/main/java/apiClient.java");

        // Initialize the OkHttpClient
        OkHttpClient client = new OkHttpClient();

        // Define the GET request
        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/posts")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            // Print response body (JSON)
            assert response.body() != null;
            System.out.println(response.body().string());
        }
        // TRY CATCH BLOCK FOR PARSING THE JSON DATA
        try {
            // Create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Parse JSON file into List of Post objects
            List<Post> posts = objectMapper.readValue(new File("src/main/java/t.txt"), new TypeReference<List<Post>>() {});

            // Print all post titles

            for (Post post : posts) {
                System.out.println(post.getTitle());
                System.out.println(post.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //STARTING POST METHOD TO SUBMIT CODE TO API KEY GIVEN
        String fileContent;

        try{
            fileContent = new String(Files.readAllBytes(file.toPath()));

        } catch (IOException e){
            e.printStackTrace();
            return;
        }

        RequestBody requestBody = RequestBody.create(
                fileContent,
                MediaType.get("text/plain; charset=utf-8")
        );

        request = new Request.Builder()
                .url("https://bean.com/api/endpoint")
                .post(requestBody)
                .addHeader("Authorization", "https://jsonplaceholder.typicode.com/posts")
                .build();

        // Dynamically sends the status codes if successful or failed
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) { //isSuccessful() is used when looking for status codes in the range of 200-299
                System.out.println(response.body().string());
                System.out.println("Success: " + response.code());
            } else {
                System.out.println("Failed: " + response.code() + " " + response.message());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //======================================================================================================




    }
}