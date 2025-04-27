package school.faang.bjs2_74165;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicInteger;

import static java.time.Instant.now;

@Slf4j
public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private static final int ONE_SECOND_MILLIS = 1000;
    private final AtomicInteger requestCounter = new AtomicInteger();
    private final Object lock = new Object();
    private Instant lastRequestTime = Instant.now();

    public void sendMessage(String msg) {
        synchronized (lock) {
            Instant now = now();
            long timePassedMillis = Duration.between(lastRequestTime, now).toMillis();

            if (timePassedMillis < ONE_SECOND_MILLIS) {
                requestCounter.incrementAndGet();
                checkRequestLimit(timePassedMillis);
            } else {
                requestCounter.set(1);
            }
            sentMessage(msg);
        }
    }

    private void checkRequestLimit(long timePassedMillis) {
        if (requestCounter.get() > REQUEST_LIMIT) {
            long sleepMillis = ONE_SECOND_MILLIS - timePassedMillis;
            try {
                log.info("Message rate-limited, sleeping for {} ms", sleepMillis);
                Thread.sleep(sleepMillis);
            } catch (InterruptedException ex) {
                log.error("Thread stoppage error", ex);
            }
        }
    }

    private void sentMessage(String msg) {
        lastRequestTime = now();
        log.info("Message has been sent: {}", msg);
    }
}


