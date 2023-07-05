package faang.school.godbless.Sprint4.Task_14_TelegramBot;

import java.time.Duration;
import java.time.LocalDateTime;

public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private int requestCounter;
    private LocalDateTime lastRequestTime;

    public TelegramBot() {
        this.requestCounter = 0;
        this.lastRequestTime = LocalDateTime.now();
    }

    public synchronized void sendMessage(String message) {
        long elapsedTime = Duration.between(lastRequestTime, LocalDateTime.now()).toMillis();

        if (elapsedTime < 1000) {
            requestCounter++;
            if (requestCounter > REQUEST_LIMIT) {
                try {
                    Thread.sleep(1000 - elapsedTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                requestCounter = 0;
            }
        } else {
            requestCounter = 0;
            lastRequestTime = LocalDateTime.now();
        }
        System.out.println("Отправка сообщения: " + message);
    }
}
