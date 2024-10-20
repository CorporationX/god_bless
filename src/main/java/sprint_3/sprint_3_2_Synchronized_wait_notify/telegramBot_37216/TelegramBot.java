package sprint_3.sprint_3_2_Synchronized_wait_notify.telegramBot_37216;

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
        this.requestCounter = 0;
        this.lastRequestTime = LocalDateTime.now();
    }

    public synchronized void sendMessage(String message) {
        LocalDateTime currentTime = LocalDateTime.now();
        Duration duration = Duration.between(lastRequestTime, currentTime);
        System.out.println("Время между запросами: " + duration.toMillis());
        if (duration.toMillis() < 1000) {
            requestCounter++;
        } else {
            requestCounter = 0;
            lastRequestTime = currentTime;
        }
        if (requestCounter >= REQUEST_LIMIT) {
            System.out.println();
            long waitTime = 1000 - duration.toMillis();
            System.out.println("Спим: " + waitTime);
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            requestCounter = 0;
            lastRequestTime = LocalDateTime.now();
        }
        System.out.println("Сообщение отправлено: " + message);
    }
}
