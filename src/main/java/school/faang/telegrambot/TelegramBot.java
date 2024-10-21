package school.faang.telegrambot;

import lombok.Getter;
import lombok.Synchronized;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    @Getter
    private int requestCounter = 0;
    @Getter
    private long lastRequestTime;

    public TelegramBot() {
        this.lastRequestTime = Instant.now().toEpochMilli();
    }

    @Synchronized
    public void sendMessage(String message) {
        long currentTime = Instant.now().toEpochMilli();
        long elapsedTime = currentTime - lastRequestTime;

        if (elapsedTime >= 1000) {
            requestCounter = 0;
            lastRequestTime = currentTime;
        }

        if (requestCounter >= REQUEST_LIMIT) {
            long waitTime = 1000 - elapsedTime;
            System.out.println("Request limit reached. Waiting for " + waitTime + " milliseconds.");
            try {
                TimeUnit.MILLISECONDS.sleep(waitTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread was interrupted during wait time.");
            }

            requestCounter = 0;
            lastRequestTime = Instant.now().toEpochMilli();
        }

        requestCounter++;
        System.out.println("Message sent: " + message);
    }
}

