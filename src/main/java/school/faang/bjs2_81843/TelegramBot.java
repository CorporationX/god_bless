package school.faang.bjs2_81843;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private static final long TIME_WINDOW_MILLIS = 1000L;

    private int requestCounter;
    private long lastRequestTime;

    public TelegramBot() {
        this.requestCounter = 0;
        this.lastRequestTime = System.currentTimeMillis();
    }

    public synchronized void sendMessage(String message) {
        long currentTime = System.currentTimeMillis();

        if (currentTime - lastRequestTime >= TIME_WINDOW_MILLIS) {
            requestCounter = 0;
            lastRequestTime = currentTime;
            log.debug("The counter has been reset. Starting a new second.");
        }

        if (requestCounter >= REQUEST_LIMIT) {
            long sleepTime = TIME_WINDOW_MILLIS - (currentTime - lastRequestTime);
            log.warn("Rate limit exceeded. Pausing thread for {} ms", sleepTime);

            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Thread interrupted during sleep", e);
                return;
            }

            requestCounter = 0;
            lastRequestTime = System.currentTimeMillis();
            log.debug("Resuming after sleep. Counter reset.");
        }

        requestCounter++;
        log.info("Message sent: '{}' | Thread: {} | Current request count: {}",
                message, Thread.currentThread().getName(), requestCounter);
    }
}
