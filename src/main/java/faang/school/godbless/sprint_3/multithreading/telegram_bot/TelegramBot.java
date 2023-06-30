package faang.school.godbless.sprint_3.multithreading.telegram_bot;

import java.time.Duration;
import java.time.LocalDateTime;

public class TelegramBot {
    private final int REQUEST_LIMIT = 5;
    private Integer requestCounter;
    private LocalDateTime lastRequestTime;

    public TelegramBot(LocalDateTime lastRequestTime) {
        this.lastRequestTime = lastRequestTime;
        requestCounter = 0;
    }

    public void sendMessage(String message) {
        LocalDateTime dateTimeNow = LocalDateTime.now();
        Duration duration = Duration.between(lastRequestTime, dateTimeNow);
        long time = duration.getSeconds();
        if (time < 1) {
            requestCounter++;
            if (requestCounter > REQUEST_LIMIT) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            } else {
                requestCounter = 0;
                lastRequestTime = LocalDateTime.now();
            }
            System.out.printf("%s отправлено.%n", message);
        }
    }
}
