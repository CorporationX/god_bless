package school.faang;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TelegramBot {
    private static final int REQUEST_LIMIT = 3;

    private int requestCounter;
    private double lastRequestTime;

    public TelegramBot() {
        this.requestCounter = 0;
        this.lastRequestTime = System.currentTimeMillis();
    }

    public void sendMessage(String message) {
        double startTime = System.currentTimeMillis();
        double elapsedTime = startTime - lastRequestTime;

        if (elapsedTime < 1000) {
            requestCounter++;
            if (requestCounter > REQUEST_LIMIT) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                requestCounter = 0;
                lastRequestTime = System.currentTimeMillis();
            }
        }
        log.info("Sending message: {}", message);
    }
}
