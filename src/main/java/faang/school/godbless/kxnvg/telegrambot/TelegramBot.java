package faang.school.godbless.kxnvg.telegrambot;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TelegramBot {

    private static final int REQUEST_LIMIT = 5;
    private int requestCounter;
    private LocalDateTime lastRequestTime;

    public TelegramBot(LocalDateTime lastRequestTime) {
        requestCounter = 0;
        this.lastRequestTime = lastRequestTime;
    }

    public synchronized void sendMessage(String message) {
        LocalDateTime nowTime = LocalDateTime.now();
        long differenceTime = lastRequestTime.until(nowTime, ChronoUnit.MILLIS);
        if (differenceTime < 1000) {
            requestCounter++;
            if (requestCounter > REQUEST_LIMIT) {
                try {
                    wait(1000 - differenceTime);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            notifyAll();
            requestCounter = 0;
            lastRequestTime = LocalDateTime.now();
        }
        System.out.println("Сообщение: " + message + " отправлено через Telegram API");
    }
}
