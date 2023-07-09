package faang.school.godbless.multithreading.synchronized_wait_notify.telegram_bot;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private static int requestCounter;
    private static LocalDateTime lastRequestTime;
    private Object lock = new Object();

    public TelegramBot() {
        this.requestCounter = 0;
        this.lastRequestTime = LocalDateTime.now();
    }

    public synchronized void sendMessage(String msg) {
        var requestTime = LocalDateTime.now();
        var difference = lastRequestTime.until(requestTime, ChronoUnit.MILLIS);
        if (difference < 5000L) {
            System.out.println(Thread.currentThread().getName()
                    + ", request count: " + requestCounter + " diff : "
                    + difference);
            if (requestCounter >= REQUEST_LIMIT) {
                try {
                    wait(5000L - difference);
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
