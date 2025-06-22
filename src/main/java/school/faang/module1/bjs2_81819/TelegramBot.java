package school.faang.module1.bjs2_81819;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TelegramBot {

    private static final int REQUEST_LIMIT = 5;
    private static final int ONE_SECOND_MILLIS = 1000;
    private int requestCounter;
    private long lastRequestTime;

    public TelegramBot() {
        this.requestCounter = 0;
        this.lastRequestTime = System.currentTimeMillis();
    }

    public synchronized void sendMessage(String message) {
        long currentTime = System.currentTimeMillis();
        long timeElapsed = currentTime - lastRequestTime;
        try {
            if (timeElapsed < ONE_SECOND_MILLIS) {
                requestCounter++;
                log.info("Прошло {} мс с последнего запроса. Текущий счётчик: {}", timeElapsed, requestCounter);
                if (requestCounter > REQUEST_LIMIT) {
                    long waitTime = ONE_SECOND_MILLIS - timeElapsed;
                    log.info("Превышен лимит запросов: {}. Поток будет ждать {} мс", requestCounter, waitTime);
                    wait(waitTime);
                    requestCounter = 0;
                    log.info("Поток проснулся. Счётчик сброшен");
                }
            } else {
                requestCounter = 1;
                lastRequestTime = currentTime;
                notifyAll();
                log.info("Прошла новая секунда. Счётчик сброшен до 1, время обновлено");
            }
            log.info("Сообщение отправлено: {}", message);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Поток был прерван во время ожидания", e);
        }
    }
}
