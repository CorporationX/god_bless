package school.faang.telegram;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Danil Pudovkin
 * @since 22.06.2025
 */
@Slf4j(topic = "TelegramBot")
public class TelegramBot {

    private static final int REQUEST_LIMIT = 5;
    private static final int ONE_SECOND_MS = 1000;

    private final AtomicInteger requestCounter;
    private final AtomicLong lastRequestTime;

    public TelegramBot() {
        this.requestCounter = new AtomicInteger(0);
        this.lastRequestTime = new AtomicLong(System.currentTimeMillis());
    }

    public void sendMessage(String message) {
        var currentTime = System.currentTimeMillis();
        var timePassed = currentTime - lastRequestTime.get();
        if (timePassed < ONE_SECOND_MS) {
            requestCounter.incrementAndGet();
            if (requestCounter.get() > REQUEST_LIMIT) {
                try {
                    log.info("Превышено максимальное количество запросов в секунду. Ожидание...");
                    Thread.sleep(Math.max(1, ONE_SECOND_MS - timePassed));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.error("Поток прерван: {}", e.getMessage());
                    return;
                }
            }
        } else {
            requestCounter.getAndSet(0);
            lastRequestTime.getAndSet(System.currentTimeMillis());
        }
        log.info("Отправка сообщения: {}", message);
    }
}
