package school.faang.telegrambot;

import java.time.Duration;
import java.time.LocalDateTime;

public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private static final int TIME_LIMIT = 1000;

    private int requestCounter;
    private LocalDateTime lastRequestTime;

    public TelegramBot() {
        this.requestCounter = 0;
        this.lastRequestTime = LocalDateTime.now();
    }

    public synchronized void sendMessage(String message) {
        LocalDateTime timeNow = LocalDateTime.now();
        long duration = Duration.between(lastRequestTime, timeNow).toMillis();
        if (requestCounter >= REQUEST_LIMIT && duration < TIME_LIMIT) {
            try {
                Thread.sleep(TIME_LIMIT - duration);
                timeNow = LocalDateTime.now();
                duration = Duration.between(lastRequestTime, timeNow).toMillis();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (duration >= TIME_LIMIT) {
            requestCounter = 0;
            lastRequestTime = LocalDateTime.now();
        }
        requestCounter++;
        System.out.println(message);
    }
}