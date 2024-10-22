package school.faang.godbless.bjs2_37243;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.LocalDateTime;

@Slf4j
public class TelegramBot {
    private final int requestLimit;
    private final int timeInterval;
    private int requestCounter;
    private LocalDateTime lastRequestTime;

    public TelegramBot(int timeInterval, int requestLimit) {
        this.timeInterval = timeInterval;
        this.requestLimit = requestLimit;
        requestCounter = 0;
        lastRequestTime = LocalDateTime.now();
    }

    public synchronized void sendMessage(String message) {
        LocalDateTime time = LocalDateTime.now();
        long timeSinceLastRequest = Duration.between(lastRequestTime, time).toMillis();
        if (timeSinceLastRequest >= timeInterval) {
            requestCounter = 0;
        }
        requestCounter++;
        if (requestCounter > requestLimit) {
            try {
                Thread.sleep(timeInterval - timeSinceLastRequest);
            } catch (InterruptedException e) {
                log.info("Thread interrupted while waiting to send a request");
                Thread.currentThread().interrupt();
            }
            requestCounter = 1;
        }
        lastRequestTime = LocalDateTime.now();
        log.info("Sent message \"{}\"", message);
    }
}
