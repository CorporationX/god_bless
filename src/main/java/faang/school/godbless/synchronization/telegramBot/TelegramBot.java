package faang.school.godbless.synchronization.telegramBot;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@Slf4j
public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private int requestCounter;
    private LocalTime lastRequestTime;

    public TelegramBot() {
        requestCounter = 0;
        lastRequestTime = LocalTime.now();
    }

    public void sendMessage(String message) {
        if (message == null || message.isBlank()) {
            log.warn("Can't process null-valued or blank message. Sending declined.");
            return;
        }

        synchronized (this) {
            var currentTime = LocalTime.now();

            var timeAfterLastRequest = ChronoUnit.MILLIS.between(lastRequestTime, currentTime);

            if (timeAfterLastRequest < 1000) {
                requestCounter++;

                long freezeTime = 1000 - timeAfterLastRequest;

                if (requestCounter > REQUEST_LIMIT) {
                    log.warn("Requests exceed limit.");
                    log.warn("Freezing for " + freezeTime + " millis");

                    try {
                        Thread.sleep(freezeTime);
                    } catch (InterruptedException e) {
                        log.warn("Waiting between requests was interrupted");
                    }

                    requestCounter = 1;
                }
            } else {
                requestCounter = 0;
                lastRequestTime = LocalTime.now();
            }

            sendViaAPI(message);
            lastRequestTime = LocalTime.now();
        }
    }

    private void sendViaAPI(String message) {
        log.info("Sent message: " + message);
    }
}
