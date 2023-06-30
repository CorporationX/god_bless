package faang.school.godbless.thirdSprint.Telegram;

import java.time.Duration;
import java.time.LocalDateTime;

public class TelegramBot {
    private static final int SECOND = 1000;
    private static final int REQUEST_LIMIT = 5;
    private int requestCounter;
    private LocalDateTime lastRequestTime;

    public TelegramBot() {
        requestCounter = 0;
        lastRequestTime = LocalDateTime.now();
    }

    public synchronized void sendMessage(String message) {
        LocalDateTime currentTime = LocalDateTime.now();
        Duration duration = Duration.between(lastRequestTime, currentTime);

        if (duration.toMillis() < SECOND) {
            requestCounter++;
            if (requestCounter == REQUEST_LIMIT) {
                try {
                    Thread.sleep(SECOND - duration.toMillis());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                requestCounter = 0;
            }
        } else {
            requestCounter = 0;
        }
        lastRequestTime = LocalDateTime.now();

        System.out.println("Message '" + message + "' sent via API Telegram");
    }
}
