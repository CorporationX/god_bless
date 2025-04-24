package school.faang.Telegram;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TelegramBot {
    private static final int REQUEST_LIMIT = 3;

    private int requestCounter;
    private long lastRequestTime;
    private final Object lock = new Object();

    public TelegramBot() {
        this.lastRequestTime = System.currentTimeMillis();
        this.requestCounter = 0;
    }

    public void sendMessage(String message) {
        synchronized (lock) {
            updateRequestCounterIfNeeded();
            waitIfCounterLimit();
            send(message);
        }
    }

    private void updateRequestCounterIfNeeded() {
        long currentTime = System.currentTimeMillis();
        long timeSinceLastRequest = currentTime - lastRequestTime;
        if (timeSinceLastRequest >= 1000) {
            requestCounter = 0;
            lastRequestTime = currentTime;
            log.info("Счетчики сброшены");
        }
    }

    private void waitIfCounterLimit() {
        while (requestCounter >= REQUEST_LIMIT) {
            long currentTime = System.currentTimeMillis();
            long limitTime = 1000 - (currentTime - lastRequestTime);

            if (limitTime > 0) {
                try {
                    log.warn("Достигнут лимит запросов. Ожидание {} мс", limitTime);
                    lock.wait(limitTime);
                    updateRequestCounterIfNeeded();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.warn("Поток был прерван во время ожидания");
                }
            } else {
                updateRequestCounterIfNeeded();
            }
        }
    }

    private void send(String message) {
        requestCounter++;
        log.info("{} | Запросов: {}/{}", message, requestCounter, REQUEST_LIMIT);
        lock.notifyAll();
    }
}
