package faang.school.godbless.telegram;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class TelegramBot {
    private final int REQUEST_LIMIT;
    private int requestCounter;
    private long lastRequestTime;

    public TelegramBot() {
        this.REQUEST_LIMIT = 3;
        this.requestCounter = 5;
        this.lastRequestTime = System.currentTimeMillis();
    }

    public synchronized void sendMessage(String message) {
        long time = System.currentTimeMillis();
        if (time - lastRequestTime < 1000) {
            requestCounter++;
            if (time - lastRequestTime > REQUEST_LIMIT) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } else if (time - lastRequestTime >= 1000) {
            requestCounter = 0;
            lastRequestTime = 0;
        }
        System.out.println("Отправлено сообщение: " + message);
    }
}
