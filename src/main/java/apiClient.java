import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.FileWriter;
import java.io.IOException;

public class apiClient {

    public static void main(String[] args) throws Exception {
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

        try(FileWriter file = new FileWriter("response.json")){



        }
    }
}