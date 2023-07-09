package faang.school.godbless.multithreading.synchronized_wait_notify.telegram_bot;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private static final long REQUEST_TIME = 1000;

    private static int requestCounter;
    private static LocalDateTime lastRequestTime;

    public TelegramBot() {
        this.requestCounter = 0;
        this.lastRequestTime = LocalDateTime.now();
    }

    public synchronized void sendMessage(String msg) {
        var requestTime = LocalDateTime.now();
        var difference = lastRequestTime.until(requestTime, ChronoUnit.MILLIS);
        if (difference < REQUEST_TIME) {
            System.out.println(Thread.currentThread().getName()
                    + ", request count: " + requestCounter + " diff : "
                    + difference);
            if (requestCounter >= REQUEST_LIMIT) {
                try {
                    wait(REQUEST_TIME - difference);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                requestCounter = 0;
            }
        }
        telegramApiService(msg);
    }

    private synchronized void telegramApiService(String msg) {
        requestCounter++;
        System.out.println("send message "
                + msg + " " + Thread.currentThread().getName()
                + ", request count: " + requestCounter);
        lastRequestTime = LocalDateTime.now();

    }
}
