package school.faang.telegrambot;

import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class TelegramBot {
    private static final int REQUEST_LIMIT = 10;
    private static final int ONE_SECOND = 1000;
    private AtomicInteger requestCounter;
    private Instant lastRequestTime;

    public TelegramBot() {
        this.requestCounter = new AtomicInteger(0);
        this.lastRequestTime = System.currentTimeMillis();
    }

    public synchronized void sendMessage(String message) {
        long currentRequestTime = System.currentTimeMillis();
        long pastTimes = currentRequestTime - lastRequestTime;

        if (pastTimes < ONE_SECOND) {
            requestCounter++;
            if (requestCounter > REQUEST_LIMIT) {
                log.info("Запросы превышают лимит, WAIT");
                try {
                    wait(ONE_SECOND - pastTimes);
                } catch (InterruptedException e) {
                    log.error("Поток прерван", e);
                    Thread.currentThread().interrupt();
                }
                requestCounter = 0;
            }
        } else {
            requestCounter = 1;
            lastRequestTime = currentRequestTime;
            notifyAll();
            log.info("NotifyAll");
        }
        log.info("Отправлен запрос: {}", message);
    }
}