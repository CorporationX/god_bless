package faang.school.godbless.telegram_bot;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;


public class TelegramBot {
    private final int REQUEST_LIMIT = 5;
    private int requestCounter = 0;
    private long lastRequestTime;
    public TelegramBot() {
        this.lastRequestTime = System.currentTimeMillis();
    }

    @SneakyThrows
    public synchronized void sendMessage(String message) {
        long currentTime = System.currentTimeMillis();
        long timeFromLastRequest = currentTime - lastRequestTime;

        if(timeFromLastRequest < 1000) {
            requestCounter++;
            if(requestCounter > REQUEST_LIMIT) {
                Thread.sleep(1000 - timeFromLastRequest);
            }
        } else if (timeFromLastRequest >= 1000) {
            requestCounter = 0;
            lastRequestTime = System.currentTimeMillis();
        }

        System.out.println("Send message: " + message);
    }
}
