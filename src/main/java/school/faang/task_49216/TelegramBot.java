package school.faang.task_49216;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TelegramBot {
    private static final int REQUEST_LIMIT = 10;

    private int requestCounter;
    private long lastRequestTime;

    public TelegramBot() {
        this.requestCounter = 0;
        this.lastRequestTime = System.currentTimeMillis();
    }

    public synchronized void sendMessage(@NonNull String message) {
        long currentTime = System.currentTimeMillis();
        long timeElapsed = currentTime - lastRequestTime;

        if (timeElapsed < 1000) {
            requestCounter++;
            if (requestCounter > REQUEST_LIMIT) {
                log.info("Превышен лимит запросов");
                try {
                    wait(1000 - timeElapsed);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.error("Thread was interrupted", e);
                }
                requestCounter = 0;
            }
        } else {
            requestCounter = 1;
            lastRequestTime = currentTime;
            notifyAll();
        }

        log.info("Сообщение отправлено: {}", message);
    }

}
