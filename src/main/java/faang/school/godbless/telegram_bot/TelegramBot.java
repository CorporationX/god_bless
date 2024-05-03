package faang.school.godbless.telegram_bot;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
@Slf4j
public class TelegramBot {
    private static final int REQUEST_LIMIT_TIME_MS = 1000;
    private final int REQUEST_LIMIT;
    private int requestCounter;
    private LocalDateTime lastRequestTime;

    public TelegramBot(int REQUEST_LIMIT) {
        this.REQUEST_LIMIT = REQUEST_LIMIT;
        this.requestCounter = 0;
        this.lastRequestTime = LocalDateTime.now();
    }

    public synchronized void sendMessage(String message) {
        LocalDateTime currentTime = LocalDateTime.now();
        long millisBetweenRequests = Duration.between(lastRequestTime, currentTime).toMillis();

        if (millisBetweenRequests < REQUEST_LIMIT_TIME_MS) {
            if (requestCounter == REQUEST_LIMIT) {
                long waitTime = REQUEST_LIMIT_TIME_MS - millisBetweenRequests;
                log.info("This request update requestCounter. Request limit exceeded, wait {} millisecond.", waitTime);
                try {
                    Thread.sleep(waitTime);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e.getMessage());
                }
                requestCounter = 0;
                lastRequestTime = LocalDateTime.now();
            }
            requestCounter++;
        } else {
            log.info("This request update requestCounter.");
            requestCounter = 1;
            lastRequestTime = LocalDateTime.now();
        }

        log.info("This message was sent: {}", message);
    }
}