package faang.school.godbless.telegram_bot;

import lombok.AllArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;

@AllArgsConstructor
public class TelegramBot {
    private final static int REQUEST_LIMIT = 5;
    private int requestCounter;
    private LocalDateTime lastRequestTime;

    public synchronized void sendMessage(String message) {
        LocalDateTime currentTime = LocalDateTime.now();
        long differenceTime = Duration.between(currentTime, lastRequestTime).toMillis();

        if (differenceTime < 1000) {
            requestCounter++;
            if (requestCounter > REQUEST_LIMIT) {
                try {
                    Thread.sleep(1000 - differenceTime);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                requestCounter = 1;
            }
        } else {
            requestCounter = 1;
        }
        lastRequestTime = LocalDateTime.now();
        System.out.println(message);
    }
}
