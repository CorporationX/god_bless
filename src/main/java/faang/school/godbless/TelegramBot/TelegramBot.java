package faang.school.godbless.TelegramBot;

import lombok.RequiredArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;

@RequiredArgsConstructor
public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private static final long REQUEST_DELAY_MILLIS = 1000L;
    private LocalDateTime lastRequestTime = LocalDateTime.now();
    private int requestCounter;

    public synchronized void sendMessage(String message) throws InterruptedException {
        LocalDateTime currentTime = LocalDateTime.now();
        long delay = Duration.between(lastRequestTime, currentTime).toMillis();
        if (delay < REQUEST_DELAY_MILLIS) {
            if (++requestCounter > REQUEST_LIMIT) {
                Thread.sleep(REQUEST_DELAY_MILLIS - delay);
            }
        } else {
            requestCounter = 0;
            lastRequestTime = currentTime;
            wait();
        }
        System.out.println(message);
        notify();
    }
}
