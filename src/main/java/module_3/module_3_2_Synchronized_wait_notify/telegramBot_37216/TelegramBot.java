package module_3.module_3_2_Synchronized_wait_notify.telegramBot_37216;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.LocalDateTime;


public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private static final Logger logger = LoggerFactory.getLogger(TelegramBot.class);

    private int requestCounter;
    private LocalDateTime lastRequestTime;

    public TelegramBot() {
        this.requestCounter = 1;
        this.lastRequestTime = LocalDateTime.now();
    }

    public synchronized void sendMessage(String message) {
        LocalDateTime currentTime = LocalDateTime.now();
        Duration duration = Duration.between(lastRequestTime, currentTime);
        logger.info("Время между запросами: {}", duration);
        if (duration.toMillis() < 1000) {
            requestCounter++;
        } else {
            requestCounter = 1;
            lastRequestTime = currentTime;
        }
        if (requestCounter > REQUEST_LIMIT) {
            long waitTime = 1000 - duration.toMillis();
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            requestCounter = 1;
            lastRequestTime = LocalDateTime.now();
        }
        logger.info("Сообщение отправлено: {}", message);
        System.out.println();
    }
}
