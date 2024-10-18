package school.faang.telegramBot;

import lombok.Data;

import java.util.Random;

@Data
public class TelegramBot {
    private static final int REQUEST_LIMIT = 3;
    private final Random random = new Random();
    private int requestCounter;
    private long lastRequestTime;

    public synchronized void sendMessage(String message) {
        try {
            Thread.sleep(random.nextInt(100, 800));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long currentTime = System.currentTimeMillis();
        long timeElapsed = currentTime - lastRequestTime;
        try {
            if (timeElapsed < 1000) {
                requestCounter++;
                if (requestCounter > REQUEST_LIMIT) {
                    wait(1000 - timeElapsed);
                    requestCounter = 0;
                }
            } else {
                requestCounter = 1;
                lastRequestTime = currentTime;
                notifyAll();
            }
            System.out.println(message + " is sent. Time between last request and this in milliseconds: " + timeElapsed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public TelegramBot() {
        this.requestCounter = 0;
        this.lastRequestTime = System.currentTimeMillis();
    }
}
