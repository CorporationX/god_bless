package faang.school.godbless.TelegramBotinok;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TelegramBot {
    private final int REQUEST_LIMIT;  //такое название по заданию потребовали
    private int requestCounter;
    private LocalDateTime lastRequestTime;
    private final Object lock = new Object();

    public TelegramBot(int REQUEST_LIMIT, LocalDateTime lastRequestTime) {
        this.REQUEST_LIMIT = REQUEST_LIMIT;
        this.lastRequestTime = lastRequestTime;
    }

    public synchronized void sendMessage(String message) {
        LocalDateTime timeNow = LocalDateTime.now();
        Duration timeSinceLastRequest = Duration.between(lastRequestTime, timeNow);

        if (timeSinceLastRequest.getSeconds() < 1) {
            requestCounter++;
            System.out.println(requestCounter);
            if (requestCounter > REQUEST_LIMIT) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            requestCounter = 0;
            lastRequestTime = timeNow;
        }
        System.out.println("отправил сообщение через telegramAPI: " + message);
    }
}
