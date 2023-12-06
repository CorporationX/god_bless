package faang.school.godbless.Telegram.bot;

import java.time.Duration;
import java.time.LocalDateTime;

public class TelegramBot {
    private final int REQUEST_LIMIT = 5;
    private Integer requestCounter;
    private LocalDateTime lastRequestTime;


    public TelegramBot(int requestCounter, LocalDateTime lastRequestTime) {
        this.requestCounter = requestCounter;
        this.lastRequestTime = lastRequestTime;
    }

    public void sendMessage(String message) {

        checkRequestCounter(getTimeSpend());

        System.out.println(Thread.currentThread().getName() + ": " + message);

    }

    private void waitToSecondEnds(long timeSpend) {
        try {
            Thread.sleep(1000 - timeSpend);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void checkRequestCounter(long timeSpend) {
        synchronized (requestCounter) {

            if (timeSpend < 1000) {
                requestCounter++;

                if (requestCounter > REQUEST_LIMIT) {
                    waitToSecondEnds(timeSpend);
                }

            } else if (timeSpend >= 1000) {
                resetValues();
            }
        }
    }

    private long getTimeSpend() {
        synchronized (lastRequestTime) {

            LocalDateTime currentTime = LocalDateTime.now();
            long timeSpend = Duration.between(lastRequestTime, currentTime).toMillis();

            return timeSpend;
        }
    }

    private void resetValues() {
        synchronized (requestCounter) {
            synchronized (lastRequestTime) {

                requestCounter = 0;
                lastRequestTime = LocalDateTime.now();

            }
        }
    }

}
