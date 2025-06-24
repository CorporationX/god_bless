package school.faang.telegram;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Danil Pudovkin
 * @since 22.06.2025
 */
@Slf4j(topic = "TelegramBot")
public class TelegramBot {

    private static final int REQUEST_LIMIT = 5;
    private static final int ONE_SECOND_MS = 1000;

    private int requestCounter = 0;
    private long lastRequestTime = System.currentTimeMillis();

    public synchronized void sendMessage(String message) {
        var currentTime = System.currentTimeMillis();
        var timePassed = currentTime - lastRequestTime;
        if (timePassed < ONE_SECOND_MS) {
            requestCounter++;
            if (requestCounter > REQUEST_LIMIT) {
                try {
                    log.info("Превышено максимальное количество запросов в секунду. Ожидание...");
                    wait(Math.max(1, ONE_SECOND_MS - timePassed));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.error("Поток прерван: {}", e.getMessage());
                    return;
                }
            }
        } else {
            requestCounter = 0;
            lastRequestTime = System.currentTimeMillis();
        }
        log.info("Отправка сообщения: {}", message);
    }
}
