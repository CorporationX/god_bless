package Sprint_4_Task14;

import lombok.SneakyThrows;

public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private int requestCounter;
    private long lastRequestTime;

    public TelegramBot( long lastRequestTime) {
        this.requestCounter = 0;
        this.lastRequestTime = lastRequestTime;
    }

    @SneakyThrows
    public synchronized void sendMessage(String message) {
        long startTime = System.currentTimeMillis();
        long timeTaken = startTime - lastRequestTime;

        if (timeTaken < 1000) {
            requestCounter++;
            if (requestCounter > REQUEST_LIMIT) {
                Thread.sleep(1000 - timeTaken);
                requestCounter = 1;
            }
            System.out.println(Thread.currentThread().getName() + " requestCounter = " + requestCounter);
            System.out.println(Thread.currentThread().getName() + " REQUEST_LIMIT = " + REQUEST_LIMIT);
        } else {
            requestCounter = 1;
        }
        lastRequestTime = System.currentTimeMillis();
        System.out.println("Отправлено сообщение: " + message);
    }
}
