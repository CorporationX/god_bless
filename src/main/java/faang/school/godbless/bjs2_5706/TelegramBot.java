package faang.school.godbless.bjs2_5706;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.LocalDateTime;

@Slf4j
public class TelegramBot {

    private static final int REQUEST_LIMIT = 5;
    private static final int REQUEST_DELAY_MS = 1000;

    private int requestCounter;
    private LocalDateTime lastRequestTime = LocalDateTime.now();

    public synchronized void sendMessage(String message) {
        LocalDateTime requestTime = LocalDateTime.now();
        long duration = Duration.between(lastRequestTime, requestTime).toMillis();
        if (duration < REQUEST_DELAY_MS) {
            requestCounter++;
            if (requestCounter > REQUEST_LIMIT) {
                try {
                    Thread.sleep(REQUEST_DELAY_MS - duration);
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                }
            }
            notify();
        } else {
            requestCounter = 0;
            lastRequestTime = requestTime;
            try {
                log.info("Too many requests. Waiting...");
                wait();
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
        }
        log.info("Message '{}' is sending...", message);
    }
}
