package faang.school.godbless.telegramBot;

import java.util.Date;
import java.util.concurrent.ExecutionException;

public class TelegramBot {
    private final int REQUEST_LIMIT;
    private int requestCounter = 0;
    private long lastRequestTime;

    public TelegramBot() {
        this.REQUEST_LIMIT = 5;
    }

    public synchronized void sendMessage() {
        long currentTime = System.currentTimeMillis();
        long pastTime = currentTime - lastRequestTime;
        if (pastTime < 1000) {
            while (requestCounter == REQUEST_LIMIT) {
                try {
                    System.out.println("Необходима пауза");
                    wait(1000 - pastTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
                if (System.currentTimeMillis() - lastRequestTime > 1000) {
                    requestCounter = 0;
                    lastRequestTime = System.currentTimeMillis();
                }
            }
        } else {
            requestCounter = 0;
            lastRequestTime = currentTime;
        }
        requestCounter++;
        System.out.println("Сообщение отправлено " + requestCounter);
        notifyAll();
    }
}
