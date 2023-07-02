package faang.school.godbless.synchronize.telegramBot;

import lombok.Data;

@Data
public class TelegramBot {
    private int requestCounter;
    private long lastRequestTime;

    private final int REQUEST_LIMIT = 5;

    public TelegramBot() {
        this.requestCounter = 0;
        this.lastRequestTime = getRequestTime();
    }

    public synchronized void sendMessage(String message) throws InterruptedException {
        long now = getRequestTime();
        long l = now - lastRequestTime;

        if (l < 1) {
            if (++requestCounter > REQUEST_LIMIT) {
                System.out.println("waiting...");
                wait(1000);
            }
        } else {
            requestCounter = 0;
            lastRequestTime = getRequestTime();
        }

        System.out.println("Sending message: " + message + " - " + Thread.currentThread().getName());
    }

    private static long getRequestTime() {
        return System.currentTimeMillis() / 1000L;
    }
}
