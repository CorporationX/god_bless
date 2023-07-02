package faang.school.godbless.Sprint_4.Multithreading_Synchronization.TelegramBot;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class TelegramBot {
    private static int REQUEST_LIMIT;
    private int requestCounter;
    private LocalDateTime lastRequestTime;

    public TelegramBot(int requestCounter, LocalDateTime lastRequestTime) {
        this.requestCounter = requestCounter;
        this.lastRequestTime = lastRequestTime;
    }

    public synchronized void sendMessage(String message) throws InterruptedException {
        LocalDateTime curRequestTime = LocalDateTime.now().minus(1, ChronoUnit.SECONDS);

        if (curRequestTime.isAfter(lastRequestTime)) {
            if (++requestCounter > REQUEST_LIMIT) {
                wait(1000);
            }
        } else {
            requestCounter = 0;
            lastRequestTime = LocalDateTime.now();
        }

        System.out.println("Message was sent");
    }
}
