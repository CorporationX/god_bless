package school.faang.task_49224;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;

    private int requestCounter;
    private long lastRequestTime;

    public TelegramBot(int requestCounter) {
        this.requestCounter = requestCounter;
        this.lastRequestTime = System.currentTimeMillis();
    }

    public synchronized void sendMessage(String message) {
        long currentTime = System.currentTimeMillis();
        long timeElapsed = currentTime - lastRequestTime;

        try {
            if (timeElapsed < 1000) {
                requestCounter++;
                if (requestCounter > REQUEST_LIMIT) {
                    log.info("Exceeded the number of requests per second");
                    wait(1000 - timeElapsed);
                    requestCounter = 0;
                }
            } else {
                requestCounter = 1;
                lastRequestTime = System.currentTimeMillis();
                notifyAll();
            }
            log.info("The message has been sent: {}", message);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}
