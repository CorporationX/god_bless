package faang.school.godbless.Sprint_4.Multithreading_Synchronization.TelegramBot;

import java.sql.Time;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class TelegramBot {
    private static final int REQUEST_LIMIT = 2;
    private int requestCounter;
    private Instant lastRequestTime;

    public TelegramBot(int requestCounter, Instant lastRequestTime) {
        this.requestCounter = 2;
        this.lastRequestTime = lastRequestTime;
    }

    public void sendMessage(String message) throws InterruptedException {
        synchronized (this) {
            Instant curRequestTime = Instant.now();

            if (curRequestTime.minus(999, ChronoUnit.MILLIS).isAfter(lastRequestTime)) {
                if (requestCounter > REQUEST_LIMIT) {
                   wait(1000);
                }
            } else {
                requestCounter = 0;
            }

            lastRequestTime = curRequestTime;
            System.out.println("Message was sent");
            requestCounter++;
        }
    }
}
