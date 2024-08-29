package faang.school.godbless.TelegramBotinok;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TelegramBot {
    private final static int REQUEST_LIMIT = 5;  //такое название по заданию потребовали
    private int requestCounter;
    private LocalDateTime lastRequestTime;

    public TelegramBot(LocalDateTime lastRequestTime, int requestCounter) {
        this.lastRequestTime = lastRequestTime;
        this.requestCounter = requestCounter;
    }

    public synchronized void sendMessage(String message) {
        LocalDateTime timeNow = LocalDateTime.now();
        long millis = timeNow.getNano() / 1_000_000;
        timeNow = timeNow.minus(millis, ChronoUnit.MILLIS);

        if (lastRequestTime == null) {
            lastRequestTime = timeNow;
        }

        Duration timeSinceLastRequest = Duration.between(lastRequestTime, timeNow);

        if (timeSinceLastRequest.getSeconds() < 1) {
            while (requestCounter > REQUEST_LIMIT) {
                try {
                    wait(1000);
                    requestCounter = 0;
                    lastRequestTime = null;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            requestCounter++;
        }

        System.out.println(requestCounter);
        System.out.println("отправил сообщение через telegramAPI: " + message);
        notifyAll();
    }
}
