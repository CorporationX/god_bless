package faang.school.godbless.sprint_3.multithreading.telegram_bot;

import java.time.Duration;
import java.time.Instant;

public class TelegramBot {
    private final int REQUEST_LIMIT = 5;
    private Integer requestCounter;
    private Instant lastRequestTime;

    public TelegramBot() {
        this.lastRequestTime = Instant.now();
        requestCounter = 0;
    }

    public synchronized void sendMessage(String message) {
        Instant dateTimeNow = Instant.now();
        Duration duration = Duration.between(lastRequestTime, dateTimeNow);
        long time = duration.getSeconds();
        if (time < 1) {
            if (requestCounter > REQUEST_LIMIT) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            } else {
                requestCounter = 0;
                lastRequestTime = Instant.now();
            }
            System.out.printf("%s отправлено.%n", message);
            requestCounter++;
        }
    }
}
