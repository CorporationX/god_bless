package school.faang.multithreading.synchron.telegram;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;

    private int requestCounter;
    private long lastRequestTime;

    public TelegramBot() {
        this.requestCounter = 0;
        this.lastRequestTime = System.currentTimeMillis();
    }

    @SneakyThrows
    public synchronized void sendMessage(String message) {
        long now = System.currentTimeMillis();
        long timeDifference = now - lastRequestTime;
        if (timeDifference < 1000) {
            requestCounter++;
            if (requestCounter >= REQUEST_LIMIT) {
                long timeWait = 1000 - timeDifference;
                log.info("Превышен лимит сообщений ждем: {} ms", timeWait);
                Thread.sleep(timeWait);
                requestCounter = 0;
            }
        } else {
            requestCounter = 1;
            lastRequestTime = now;
        }

        log.info("Сообщение отправлено: {}", message);
    }
}
