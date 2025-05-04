package school.faang.telegramm;

import lombok.Data;

@Data
public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private int requestCounter;
    private long lastRequestTime = System.currentTimeMillis();

    public synchronized void sendMessage(String message) {
        long currentTime = System.currentTimeMillis();
        long timeElapsed = currentTime - lastRequestTime;

        if (timeElapsed >= 1000) {
            requestCounter = 0;
            lastRequestTime = currentTime;
        }

        if (requestCounter >= REQUEST_LIMIT) {
            long waitTime = 1000 - timeElapsed;
            try {
                System.out.printf("%s превысил лимит, ждёт %d мс%n", Thread.currentThread().getName(), waitTime);
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            requestCounter = 0;
            lastRequestTime = System.currentTimeMillis();
        }

        requestCounter++;
        System.out.println(Thread.currentThread().getName() + " отправил сообщение: " + message);
    }
}
