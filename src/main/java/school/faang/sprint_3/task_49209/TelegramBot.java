package school.faang.sprint_3.task_49209;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private static final int MILLIS_IN_SECOND = 1000;
    private int requestCounter = 0;
    private long lastRequestTime = System.currentTimeMillis();

    public synchronized void sendMessage(String message) {
        while (requestCounter >= REQUEST_LIMIT) {
            long now = System.currentTimeMillis();
            long millisAfterLastRequest = now - lastRequestTime;
            if (millisAfterLastRequest > MILLIS_IN_SECOND) {
                resetTime(now);
            }
            try {
                long waitTime = MILLIS_IN_SECOND - millisAfterLastRequest;
                log.info("Waiting {} milliseconds before sending {}", waitTime, message);
                if (waitTime > 0) {
                    wait(waitTime);
                }
            } catch (InterruptedException e) {
                log.info("Message send interrupted");
                Thread.currentThread().interrupt();
                return;
            }
        }

        requestCounter++;
        log.info("{} sent", message);
    }

    private void resetTime(long now) {
        lastRequestTime = now;
        requestCounter = 0;
        notifyAll();
    }
}
