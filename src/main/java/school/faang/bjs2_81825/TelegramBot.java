package school.faang.bjs2_81825;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TelegramBot {
    private static final int REQUEST_LIMIT = 9;
    private static final int ONE_SECOND_MS = 1000;

    private int requestCounter;
    private long lastRequestTime;

    public TelegramBot() {
        this.requestCounter = 0;
        this.lastRequestTime = System.currentTimeMillis();
    }

    public synchronized void sendMessage(String message) {
        long currentTime = System.currentTimeMillis();
        long duration = currentTime - lastRequestTime;

        if (duration < ONE_SECOND_MS) {
            requestCounter++;

            if (requestCounter > REQUEST_LIMIT) {
                try {
                    long waitTime = ONE_SECOND_MS - duration;
                    log.debug("Достигнут лимит, ожидаем {} мс", waitTime);
                    wait(waitTime);
                } catch (InterruptedException e) {
                    log.error("Ошибка ожидания запроса: {}", e.getMessage());
                }
            }
        } else {
            requestCounter = 1;
            lastRequestTime = currentTime;
            notifyAll();
        }

        log.info("Тут проиcходит отправка сообщения: {}", message);
    }
}
