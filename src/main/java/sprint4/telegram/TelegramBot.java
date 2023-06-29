package sprint4.telegram;

import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
public class TelegramBot {
    private static final int SECOND = 1000;
    private final int requestLimit;
    private LocalDateTime lastRequestTime;
    private int requestCounter;

    public TelegramBot(int requestLimit, LocalDateTime lastRequestTime) {
        this.requestLimit = requestLimit;
        this.lastRequestTime = lastRequestTime;
    }

    public synchronized void sendMessage(String message) {
        long timeSinceLastRequestInMillis = Duration.between(lastRequestTime, LocalDateTime.now()).toMillis();

        if (timeSinceLastRequestInMillis < SECOND) {
            requestCounter++;
            waitIfLimitIsExceeded(timeSinceLastRequestInMillis);
        } else {
            requestCounter = 0;
        }
        lastRequestTime = LocalDateTime.now();

        System.out.printf("Message sent via Telegram API: %s\n", message);
    }

    private void waitIfLimitIsExceeded(long timeSinceLastRequestInMillis) {
        if (requestCounter == requestLimit) {
            try {
                Thread.sleep(1000 - timeSinceLastRequestInMillis);
            } catch (InterruptedException e) {
                System.out.println("Work interrupted");
            }
            requestCounter = 0;
        }
    }
}
