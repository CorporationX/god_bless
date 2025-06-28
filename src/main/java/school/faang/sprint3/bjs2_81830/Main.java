package school.faang.sprint3.bjs2_81830;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static final int THREAD_BATCH = 5;

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
