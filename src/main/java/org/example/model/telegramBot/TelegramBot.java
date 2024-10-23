package org.example.model.telegramBot;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalTime;

@Slf4j
@AllArgsConstructor
public class TelegramBot {
    private final int REQUEST_LIMIT_FOR_SECOND = 5;
    private int requestCounter;
    private long lastRequestTime;

    public void sendMessage(String message) {
        synchronized (this) {
            long currentTime = System.currentTimeMillis();
            if (isPossibleToSendRequest(currentTime)) {
                log.info("sent message {}, time: {}, request-counter: {}", message, LocalTime.now().getSecond(), requestCounter);
            } else {
                try {
                    Thread.sleep(1000 - (currentTime - lastRequestTime));
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                }
                requestCounter = 1;
                lastRequestTime = System.currentTimeMillis();
                log.info("sent message {}, time: {}, request-counter: {}", message, LocalTime.now().getSecond(), requestCounter);
            }
        }

    }

    private boolean isPossibleToSendRequest(long currentTime) {
        long duration = Math.abs(currentTime - lastRequestTime);

        if (duration < 1000 && requestCounter < REQUEST_LIMIT_FOR_SECOND) {
            requestCounter++;
            return true;
        } else if (duration < 1000) {
            return false;
        }
        requestCounter = 1;
        lastRequestTime = currentTime;
        return true;
    }
}