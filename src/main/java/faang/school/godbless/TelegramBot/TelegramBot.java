package faang.school.godbless.TelegramBot;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TelegramBot {
    private final int REQUEST_LIMIT = 5;
    private Integer requestCounter;
    private long lastRequestTime;

    public TelegramBot(int requestCounter, long lastRequestTime) {
        this.requestCounter = requestCounter;
        this.lastRequestTime = lastRequestTime;
    }

    public synchronized void sendMessage(String message) throws InterruptedException {
            long start = System.currentTimeMillis();
            long timePassed = lastRequestTime - start;
            if (timePassed < 1000) {
                requestCounter++;
                if (requestCounter > REQUEST_LIMIT) {
                    message.wait(1000 - timePassed);
                }
            } else {
                requestCounter = 0;
                lastRequestTime = 0;
            }
            System.out.println(message + " sent at " + LocalDateTime.now());
            message.notify();
        }
}
