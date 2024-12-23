package school.faang.sprint3.bjs_49285;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREADS_COUNT = 4;
    private static final int TIMEOUT = 300;

    public static void main(String[] args) throws InterruptedException {
        TelegramBot bot = new TelegramBot();
        String message = "Привет, как дела?";
        ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);

        for (int i = 0; i < THREADS_COUNT; i++) {
            executor.submit(() -> bot.sendMessage(message));
        }

        executor.shutdown();
        executor.awaitTermination(TIMEOUT, TimeUnit.SECONDS);
    }
}
