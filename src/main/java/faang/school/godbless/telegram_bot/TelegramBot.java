package faang.school.godbless.telegram_bot;

import java.time.LocalDateTime;
import java.time.Duration;

public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private int requestCounter;
    private LocalDateTime lastRequestTime;

    public TelegramBot() {
        this.requestCounter = 0;
        this.lastRequestTime = LocalDateTime.now();
    }

    public void sendMessage(String message){
        LocalDateTime currentTime = LocalDateTime.now();
        Duration duration = Duration.between(lastRequestTime, currentTime);

        if (duration.getSeconds() < 1) {
            requestCounter++;
            if (requestCounter >= REQUEST_LIMIT) {
                try {
                    Thread.sleep((1 - duration.getSeconds()) * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            requestCounter = 0;
            lastRequestTime = currentTime;
        }
        System.out.println("Отправка сообщения: " + message);
    }
}
