package school.faang.telegrambot;

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

    public synchronized void sendMessage(String message) {
        long currentRequestTime = System.currentTimeMillis();
        long pastTimes = currentRequestTime - lastRequestTime;

        if (pastTimes < 1000) {
            requestCounter++;
            if (requestCounter > REQUEST_LIMIT) {
                log.info("Запросы превышают лимит, WAIT");
                try {
                    wait(1000 - pastTimes);
                } catch (InterruptedException e) {
                    log.error("Поток прерван", e);
                    Thread.currentThread().interrupt();
                }
                requestCounter = 0;
            }
        } else {
            requestCounter = 1;  // Обнуляем счетчик запросов
            lastRequestTime = currentRequestTime;  // Обновляем время последнего запроса
            notifyAll();
            log.info("NotifyAll");
        }
        log.info("Отправлен запрос: {}", message);
    }
}