package faang.school.godbless.telegramBot;

import java.util.Date;

public class TelegramBot {
    private final int REQUEST_LIMIT;
    private int requestCounter = 0;
    private long lastRequestTime;

    public TelegramBot(long lastRequestTime) {
        this.REQUEST_LIMIT = 5;
        this.lastRequestTime = lastRequestTime;
    }

    public synchronized void sendMessage() {
        long currentTime = System.currentTimeMillis();
        long pastTime = currentTime - lastRequestTime;
        if (pastTime > 1000) {
            requestCounter = 0;
        } else {
            requestCounter++;
        }
        if (requestCounter > REQUEST_LIMIT) {
            try {
                Thread.currentThread().wait(1000 - pastTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Сообщение отправлено");

    }
}
