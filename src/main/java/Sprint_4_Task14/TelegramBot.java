package Sprint_4_Task14;

import lombok.SneakyThrows;

import java.time.LocalDateTime;

public class TelegramBot {
    private int REQUEST_LIMIT;
    private int requestCounter;
    private long lastRequestTime;

    public TelegramBot(int REQUEST_LIMIT, long lastRequestTime) {
        this.REQUEST_LIMIT = REQUEST_LIMIT;
        this.requestCounter = 0;
        this.lastRequestTime = lastRequestTime;
    }

    @SneakyThrows
    public synchronized void sendMessage(String message) {
        long startTime = System.currentTimeMillis();
        long timeTaken = startTime - lastRequestTime;
        if (timeTaken < 1000) {
            requestCounter++;
        } else {
            requestCounter = 0;
            lastRequestTime = 0;
        }
        System.out.println(Thread.currentThread().getName() + " requestCounter = " + requestCounter);
        System.out.println(Thread.currentThread().getName() + " REQUEST_LIMIT = " + REQUEST_LIMIT);
        if (requestCounter > REQUEST_LIMIT) {
            System.out.println(Thread.currentThread().getName() + " timeTaken = " + timeTaken);
            Thread.sleep(1000 - timeTaken);
            this.wait();
        } else {
            this.notifyAll();
        }
        System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + " " + message);
    }
}
