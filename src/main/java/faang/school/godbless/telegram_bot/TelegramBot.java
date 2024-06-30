package faang.school.godbless.telegram_bot;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.LocalDateTime;

@Slf4j
public class TelegramBot {
    private final int REQUEST_LIMIT = 5;
    private int requestCounter;
    private LocalDateTime lastRequestTime;

    public TelegramBot(int requestCounter, LocalDateTime lastRequestTime) {
        this.requestCounter = requestCounter;
        this.lastRequestTime = lastRequestTime;
    }

    public void sendMessage(String message) {
        LocalDateTime currentTime = LocalDateTime.now();
        long delayInMillis = Duration.between(lastRequestTime, currentTime).toMillis();

        processMessage(delayInMillis, currentTime);

        log.info("Message " + message + " was sent at " + currentTime + ". And counter is " + requestCounter);
    }

    private synchronized void processMessage(long delayInMillis, LocalDateTime currentTime) {
        if (delayInMillis < 1000) {
            if (requestCounter == REQUEST_LIMIT) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    log.warn("Thread was interrupted: " + e.getMessage());
                }
                resetCounterAndLastRequestTime(currentTime);
            }
        } else {
            resetCounterAndLastRequestTime(currentTime);
        }
        increaseCounter();
    }

    private void resetCounterAndLastRequestTime(LocalDateTime newLastDateTime) {
        requestCounter = 0;
        lastRequestTime = newLastDateTime;
    }

    private void increaseCounter() {
        requestCounter++;
    }
}
