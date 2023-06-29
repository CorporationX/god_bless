package telegram_bot;

import lombok.SneakyThrows;

import java.time.Duration;
import java.time.LocalDateTime;

public class TelegramBot {
    private final int REQUEST_LIMIT;
    private int requestCounter;
    private LocalDateTime lastRequestTime;

    public TelegramBot(int REQUEST_LIMIT) {
        this.REQUEST_LIMIT = REQUEST_LIMIT;
        this.requestCounter = 0;
        this.lastRequestTime = LocalDateTime.now();
    }

    @SneakyThrows
    public synchronized void sendMessage(String message) {
        LocalDateTime currentTime = LocalDateTime.now();
        Duration elapsed = Duration.between(lastRequestTime, currentTime);

        if (elapsed.toMillis() < 1000) {
            requestCounter++;
            if (requestCounter > REQUEST_LIMIT) {
                wait(1000 - elapsed.toMillis());
            }
        } else {
            requestCounter = 0;
        }
            lastRequestTime = LocalDateTime.now();

        System.out.println("Sending message: " + message);

        notifyAll();
    }
}
