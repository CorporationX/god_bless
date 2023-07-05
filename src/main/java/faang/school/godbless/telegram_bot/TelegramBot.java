package faang.school.godbless.telegram_bot;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;


public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private int requestCounter = 0;
    private LocalDateTime lastRequestTime;

    public TelegramBot (LocalDateTime lastRequestTime) {
        this.lastRequestTime = lastRequestTime;
    }


    @SneakyThrows
    public synchronized void sendMessage(String message) {
        long timeFromLastRequest = Duration.between(lastRequestTime, LocalDateTime.now()).toMillis();
        if(timeFromLastRequest < 1000) {
            if(requestCounter == REQUEST_LIMIT) {
                wait(3000 - timeFromLastRequest);
                requestCounter = 0;
            }
        } else {
            requestCounter = 0;
        }
        lastRequestTime = LocalDateTime.now();
        System.out.println("Send message: " + message);
        requestCounter++;
    }
}
