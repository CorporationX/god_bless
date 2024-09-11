package faang.school.godbless.module1.sprint4.task5;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class CrptApi {
    private final HttpClient httpClient;
    private final String signature;
    private final ObjectMapper objectMapper;
    private final TimeUnit timeUnit = TimeUnit.SECONDS;
    private final Duration timeDuration = Duration.ofMillis(timeUnit.toMillis(1));
    private final ExecutorService executorService;
    private int requestCounter;
    private long lastRequestTime;

    public CrptApi(String signature) {
        this.httpClient = HttpClient.newHttpClient();
        this.signature = signature;
        this.objectMapper = new ObjectMapper();
        this.executorService = Executors.newFixedThreadPool(5);
        this.requestCounter = 0;
        this.lastRequestTime = System.currentTimeMillis();
    }

    public String convertDocumentToJson(Document document) throws JsonProcessingException {
        return objectMapper.writeValueAsString(document);
    }

    public void createDocument(Document document) {
        executorService.submit(() -> {
            try {
                throttleRequests();
                String requestBody = convertDocumentToJson(document);
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create("https://ismp.crpt.ru/api/v3/lk/documents/create"))
                        .header("Content-Type", "application/json")
                        .header("Authorization", "Bearer " + signature)
                        .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                        .build();

                HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

                if (response.statusCode() == 200) {
                    System.out.println("Document created successfully.");
                } else {
                    System.err.println("Failed to create document: " + response.body());
                }

            } catch (IOException | InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Failed to send the request", e);
            }
        });
    }

    private synchronized void throttleRequests() throws InterruptedException {
        long currentTime = System.currentTimeMillis();
        int requestLimit = 5;
        if (requestCounter >= requestLimit) {
            long timeSinceLastRequest = currentTime - lastRequestTime;
            if (timeSinceLastRequest < timeDuration.toMillis()) {
                long sleepTime = timeDuration.toMillis() - timeSinceLastRequest;
                System.out.println("Sleeping for " + sleepTime + " ms to respect rate limit");
                Thread.sleep(sleepTime);
            }
            requestCounter = 0;
            lastRequestTime = System.currentTimeMillis();
        }
        requestCounter++;
    }

    public void shutdown() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }

    @Getter
    @Setter
    public static class Document {
        private Map<String, Object> description;
    }
}


