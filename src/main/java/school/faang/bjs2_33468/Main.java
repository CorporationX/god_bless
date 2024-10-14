package school.faang.bjs2_33468;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    public static void main(String[] args) {
        //
        String result = ErrorHandler.withErrorHandling(
                () -> getBodyResponse("www.google.com"),
                e -> "Не удалось получить тело ответа"
        );
        System.out.println(result);
    }

    public static String getBodyResponse(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
