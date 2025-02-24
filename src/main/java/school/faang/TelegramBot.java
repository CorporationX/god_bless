package school.faang;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.LocalDateTime;

@Slf4j
@AllArgsConstructor
public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private static final int MILLIS_IN_SECOND = 1000;
    private int requestCounter;
    private LocalDateTime lastRequestTime;

    public synchronized void sendMessage(String message) {
        LocalDateTime now = LocalDateTime.now();
        long timeElapsedMillis = Duration.between(lastRequestTime, now).toMillis();
        if (timeElapsedMillis < MILLIS_IN_SECOND) {
            requestCounter++;
            if (requestCounter > REQUEST_LIMIT) {
                try {
                    Thread.sleep(MILLIS_IN_SECOND - timeElapsedMillis);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
        } else {
            requestCounter = 1;
            lastRequestTime = now;
        }
        log.info("Message \"{}\" has been sent.", message);
    }
}