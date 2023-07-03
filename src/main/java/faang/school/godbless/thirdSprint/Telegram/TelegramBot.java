package faang.school.godbless.thirdSprint.Telegram;

import java.time.Duration;
import java.time.Instant;

public class TelegramBot {
    private static final int SECOND_MILLIS = 1000;
    private static final int REQUEST_LIMIT = 5;
    private int requestCounter;
    private Instant lastRequestTime;

    public TelegramBot() {
        requestCounter = 0;
        lastRequestTime = Instant.now();
    }

    public synchronized void sendMessage(String message) {
        Instant currentTime = Instant.now();
        Duration duration = Duration.between(lastRequestTime, currentTime);

        if (duration.toMillis() < SECOND_MILLIS) {
            if (requestCounter >= REQUEST_LIMIT) {
                try {
                    Thread.sleep(SECOND_MILLIS - duration.toMillis());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                requestCounter = 0;
            }
        } else {
            requestCounter = 0;
        }
        lastRequestTime = Instant.now();

        System.out.println("Message '" + message + "' sent via API Telegram");
        requestCounter++;
    }
}
