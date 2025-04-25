package school.faang.bjs2_74165;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@AllArgsConstructor
@Slf4j
public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private static final int ONE_SECOND_MILLIS = 1000;

    private int requestCounter;
    private LocalDateTime lastRequestTime;

    public synchronized void sendMessage(String msg) {
        LocalDateTime now = now();
        long timePassedMillis = Duration.between(lastRequestTime, now).toMillis();

        if (timePassedMillis < ONE_SECOND_MILLIS) {
            requestCounter++;
            if (requestCounter > REQUEST_LIMIT) {
                long sleepMillis = ONE_SECOND_MILLIS - timePassedMillis;
                try {
                    log.info("Message rate-limited, sleeping for {} ms", sleepMillis);
                    wait(sleepMillis);
                    requestCounter = 0;
                } catch (InterruptedException ex) {
                    log.error("Thread stoppage error", ex);
                    Thread.currentThread().interrupt();
                }
            }
        } else {
            requestCounter = 1;
            notifyAll();
        }

        lastRequestTime = now();
        log.info("Message has been sent: {}", msg);
    }
}


