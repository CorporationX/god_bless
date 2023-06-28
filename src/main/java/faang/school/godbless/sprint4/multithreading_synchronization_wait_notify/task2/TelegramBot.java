package faang.school.godbless.sprint4.multithreading_synchronization_wait_notify.task2;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TelegramBot {

    private final int REQUEST_LIMIT;

    private int requestCounter;

    private LocalDateTime lastRequestTime;

    public TelegramBot(int REQUEST_LIMIT, LocalDateTime lastRequestTime) {
        this.REQUEST_LIMIT = REQUEST_LIMIT;
        this.lastRequestTime = lastRequestTime;
    }

    public void sendMessage(String message) throws InterruptedException {
        ZonedDateTime zdt = ZonedDateTime.of(lastRequestTime, ZoneId.systemDefault());
        long last = zdt.toInstant().toEpochMilli();
        LocalDateTime now = LocalDateTime.now();
        zdt = ZonedDateTime.of(now, ZoneId.systemDefault());
        long current = zdt.toInstant().toEpochMilli();
        long duration = current - last;
        System.out.println("Duration: " + duration);

        synchronized (this) {
            if (duration < 1000) {
                requestCounter++;
                System.out.println("requestCounter: " + requestCounter);
                if (requestCounter > REQUEST_LIMIT) {
                    this.wait(1_000 - duration);
                    requestCounter = 0;
                    lastRequestTime = lastRequestTime.minusMinutes(2);
                    this.notifyAll();
                }
            }
        }

        System.out.println("Sending message: " + message);
    }
}
