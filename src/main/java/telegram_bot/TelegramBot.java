package telegram_bot;

import java.time.Duration;
import java.time.LocalDateTime;

public class TelegramBot {
    private final int REQUEST_LIMIT;
    private int requestCounter;
    private LocalDateTime lastRequestTime;

    public TelegramBot(int requestLimit, LocalDateTime lastRequestTime, int requestCounter) {
        this.lastRequestTime = lastRequestTime;
        REQUEST_LIMIT = requestLimit;
        this.requestCounter = 0;
    }

    public void sendMessage(String message) {
        synchronized (this) {
            LocalDateTime currentTime = LocalDateTime.now();
            Duration timeSinceTheLastRequest = Duration.between(lastRequestTime, currentTime);
            long millisSinceTheLastRequest = timeSinceTheLastRequest.toMillis();

            if (millisSinceTheLastRequest < 1000) {
                requestCounter++;
                if (requestCounter > REQUEST_LIMIT) {
                    try {
                        Thread.sleep(1000 - millisSinceTheLastRequest);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    requestCounter = 1;
                }
            } else {
                requestCounter = 1;
            }

            lastRequestTime = LocalDateTime.now();
        }
        System.out.println("Message \"" + message + "\" sent" + " by " + Thread.currentThread().getName());
    }
}

