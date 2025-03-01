package school.faang.third_sprint;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TelegramBot {
    private static final int REQUEST_LIMIT = 3;
    private static final int TIME_LIMIT = 1000;

    private int requestCounter;
    private long lastRequestTime;

    public TelegramBot() {
        this.requestCounter = 0;
        this.lastRequestTime = System.currentTimeMillis();
    }

    public synchronized void sendMessage(String message) {
        long startTime = System.currentTimeMillis();
        long elapsedTime = startTime - lastRequestTime;

        if (elapsedTime < TIME_LIMIT) {
            requestCounter++;
            if (requestCounter > REQUEST_LIMIT) {
                try {
                    wait(TIME_LIMIT - elapsedTime);
                } catch (InterruptedException e) {
                    log.error("awaitTermination was interrupted");
                    Thread.currentThread().interrupt();
                }
            } else {
                requestCounter = 1;
                lastRequestTime = System.currentTimeMillis();
                notifyAll();
            }
        }
        log.info("Sending message: {}", message);
    }
}
