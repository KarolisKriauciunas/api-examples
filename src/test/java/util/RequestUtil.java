package util;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestUtil {
    public static HttpResponse<String> getResponse(String url){

        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        }
        catch (IOException | InterruptedException e)
        {
            throw new RuntimeException();
        }
    }

    public static void debug(HttpResponse<String> response) {
        System.out.println("HTTP Status Code: " + response.statusCode());
        System.out.println("Response Body: " + response.body());
    }
}
