package school.faang.telegrambot;

import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private static final int ONE_SECOND = 1000;
    private static final int ZERO_COUNTER = 0;
    private final AtomicInteger requestCounter;
    private volatile Instant lastRequestTime;

    public TelegramBot() {
        this.requestCounter = new AtomicInteger(0);
        this.lastRequestTime = Instant.now();
    }

    public void sendMessage(String message) {
        synchronized (this) {
            Instant currentRequestTime = Instant.now();
            long timeDifference = currentRequestTime.toEpochMilli() - lastRequestTime.toEpochMilli();

            if (timeDifference < ONE_SECOND) {
                log.info("Прошло меньше секунды");
                if (requestCounter.incrementAndGet() > REQUEST_LIMIT) {
                    log.info("Запросы превышают лимит");
                    waitingNextSecondAndZeroingCounter(timeDifference);
                    requestCounter.incrementAndGet();
                    this.lastRequestTime = currentRequestTime;
                }
            } else {
                log.info("Прошло больше секунды");
                requestCounter.set(ZERO_COUNTER);
                requestCounter.incrementAndGet();
                this.lastRequestTime = currentRequestTime;
            }
        }
        log.info("Отправлен запрос: {}, счетчик равен: {}", message, requestCounter.get());
    }

    private void waitingNextSecondAndZeroingCounter(long timeDifference) {
        try {
            log.info("Обнуляем счетчик и дожидаемся следующей секунды");
            TimeUnit.MILLISECONDS.sleep(ONE_SECOND - timeDifference);
            requestCounter.set(ZERO_COUNTER);
        } catch (InterruptedException e) {
            log.error("Поток прерван", e);
            Thread.currentThread().interrupt();
        }
    }

    public void terminatedExecutor(ExecutorService executor) {
        try {
            TimeUnit.SECONDS.sleep(10);
            executor.shutdown();
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Поток прерван");
            executor.shutdownNow();
        }
        log.info("Задача выполнена");
    }
}