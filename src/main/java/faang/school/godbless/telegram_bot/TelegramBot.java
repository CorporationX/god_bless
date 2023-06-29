package faang.school.godbless.telegram_bot;

import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;

@Getter
public class TelegramBot {

    private static final int REQUEST_LIMIT = 5;
    private int requestCounter = 0;
    private LocalDateTime lastRequestTime = LocalDateTime.now();

    public synchronized void sendMessage(String message) {
        LocalDateTime currentTime = LocalDateTime.now();
        long timePassed = Duration.between(lastRequestTime, currentTime).toMillis();
        long oneSecond = 1000;


        if (timePassed < oneSecond) {
            requestCounter++;

            if (requestCounter > REQUEST_LIMIT) {
                try {
                    wait(oneSecond - timePassed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        } else {
            requestCounter = 0;
            lastRequestTime = currentTime;
        }

        System.out.println("Sending message: " + message);

        if (requestCounter == REQUEST_LIMIT) {
            notifyAll();
        }
    }
}
