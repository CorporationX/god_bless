package faang.school.godbless.telegram_bot;

import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;

@Getter
public class TelegramBot {

    private static final long ONE_SECOND = 1_000L;
    private static final int REQUEST_LIMIT = 5;
    private int requestCounter = 0;
    private LocalDateTime lastRequestTime = LocalDateTime.now();

    public synchronized void sendMessage(String message) {
        LocalDateTime currentTime = LocalDateTime.now();
        long timePassed = Duration.between(lastRequestTime, currentTime).toMillis();

        if (timePassed < ONE_SECOND) {
            requestCounter++;

            if (requestCounter > REQUEST_LIMIT) {
                try {
                    wait(ONE_SECOND - timePassed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            lastRequestTime = currentTime;
            requestCounter = 0;
        }

        System.out.println("Sending message: " + message);
    }
}
