package school.faang.bjs2_81825;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 100;
    private static final int TIMEOUT = 10;

    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 0; i < NUM_THREADS; i++) {
            String message = "Hello " + i;
            executor.submit(() -> bot.sendMessage(message));
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                log.info("Досрочное завершение потоков");
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
