package faang.school.godbless.telegram.bot;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;

@Slf4j
@Data
public class TelegramBot {

    private static final int REQUEST_LIMIT = 5;
    private static final long REQUEST_INTERVAL_MS = 1000;

    private int requestCounter;

    private long lastRequestTime;

    public TelegramBot() {
        this.lastRequestTime = Instant.now().toEpochMilli();
    }

    public synchronized void sendMessage(String message) {
        long currentTime = Instant.now().toEpochMilli();
        log.debug("Current Time {}: ms", currentTime);
        log.debug("Last Request Time: {} ms", lastRequestTime);

        long elapsedTime = currentTime - lastRequestTime;
        log.debug("Elapsed time since the last request: {} ms", elapsedTime);

        if (elapsedTime < REQUEST_INTERVAL_MS) {
            requestCounter++;
            if (requestCounter > REQUEST_LIMIT) {
                try {
                    wait(REQUEST_INTERVAL_MS - elapsedTime);
                } catch (InterruptedException e) {
                    log.error("Thread interrupted while waiting: {}", e.getMessage());
                    Thread.currentThread().interrupt();
                }
            }
        } else {
            requestCounter = 0;
            lastRequestTime = currentTime;
        }
        System.out.println("Sending message: " + message);
        notify();
    }
}
