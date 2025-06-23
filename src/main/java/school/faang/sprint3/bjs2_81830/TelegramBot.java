package school.faang.sprint3.bjs2_81830;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TelegramBot {
    public static final int THREAD_BATCH = 5;
    public static final int REQUEST_LIMIT = 5;
    public static final int LIMIT_INTERVAL = 1000;
    public int requestCounter;
    public long lastRequestTime;

    TelegramBot() {
        this.requestCounter = 0;
        this.lastRequestTime = System.currentTimeMillis();
    }

    public synchronized void sendMessage(String message) {
        long dateTime = System.currentTimeMillis();
        long diff = dateTime - lastRequestTime;
        try {
            Thread.sleep(100);
            if (diff < LIMIT_INTERVAL) {
                requestCounter++;
                if (requestCounter > REQUEST_LIMIT) {
                    long timeoutMillis = LIMIT_INTERVAL - diff;
                    wait(LIMIT_INTERVAL - diff);
                    System.out.println("Превышение лимита, ожидание: " + timeoutMillis);
                    requestCounter = 0;
                }
            } else {
                requestCounter = 1;
                lastRequestTime = dateTime;
                notifyAll();
            }
            System.out.println("Отправлено сообщение: " + message);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_BATCH);
        TelegramBot bot = new TelegramBot();
        for (int i = 0; i < 30; i++) {
            String message = "message " + i;
            executor.execute(() -> bot.sendMessage(message));
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
