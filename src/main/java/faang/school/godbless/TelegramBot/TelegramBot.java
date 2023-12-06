package faang.school.godbless.TelegramBot;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TelegramBot {
    private final int REQUEST_LIMIT = 5;
    private Integer requestCounter;
    private long lastRequestTime;

    public TelegramBot() {
        this.requestCounter = 0;
        this.lastRequestTime = System.currentTimeMillis();
    }

    public synchronized void sendMessage(String message) {
        long start = System.currentTimeMillis();
        long timePassed = start - lastRequestTime;
        if (timePassed < 1000) {
            requestCounter++;
            if (requestCounter > REQUEST_LIMIT) {
                try {
                    Thread.sleep((1000 - timePassed));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                requestCounter = 1;
                lastRequestTime = start;
            }
        } else {
            requestCounter = 1;
            lastRequestTime = start;
        }
        System.out.println(message + " sent at " + LocalDateTime.now() + " / " + "RequestCounter:" + requestCounter + " / " + "Time passed: " + timePassed);
    }
}
