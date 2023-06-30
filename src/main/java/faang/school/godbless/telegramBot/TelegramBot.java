package faang.school.godbless.telegramBot;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private static final int SECOND_IN_MILLIS = 1000;

    private int requestCounter;
    private long lastRequestTime;

    public TelegramBot() {
        this.requestCounter = 0;
        this.lastRequestTime = System.currentTimeMillis();
    }

    public synchronized void sendMessage(String message) {
        long currentTime = System.currentTimeMillis();
        long expiredTime = currentTime - lastRequestTime;

        if (expiredTime < SECOND_IN_MILLIS) {
            requestCounter++;

            if (requestCounter > REQUEST_LIMIT) {
                try {
                    wait(SECOND_IN_MILLIS - expiredTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            requestCounter = 0;
            lastRequestTime = currentTime;
        }

        System.out.println("Sending message: " + message);
    }
}
