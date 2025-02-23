package bjs2_61491;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TelegramBot {
    private final int MS_PER_SECOND = 1000;
    private final int REQUEST_LIMIT = 5;

    private int requestCounter = 0;
    private long lastRequestTime = System.currentTimeMillis();

    public synchronized void sendMessage(String message) throws InterruptedException {
        long now = System.currentTimeMillis();
        var elapsedTimeFromLastRequestMs = now - lastRequestTime;

        if (elapsedTimeFromLastRequestMs < MS_PER_SECOND) {
            if (++requestCounter > REQUEST_LIMIT) {
                wait(1000 - elapsedTimeFromLastRequestMs);
                requestCounter = 0;
            }
        } else {
            requestCounter = 1;
            lastRequestTime = now;
        }

        log.info("Сообщение '{}' отправлено", message);
    }
}
