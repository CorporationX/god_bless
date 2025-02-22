package school.faang;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Slf4j
@AllArgsConstructor
public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private int requestCounter;
    private LocalDateTime lastRequestTime;

    public synchronized void sendMessage(String message) {
        LocalDateTime now = LocalDateTime.now();
        long timeElapsedMillis = ChronoUnit.MILLIS.between(lastRequestTime, now);
        if (timeElapsedMillis < 1000) {
            requestCounter++;
            if (requestCounter > REQUEST_LIMIT) {
                try {
                    Thread.sleep(1000 - timeElapsedMillis);
                } catch (InterruptedException e) {
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