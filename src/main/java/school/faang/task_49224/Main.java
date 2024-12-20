package school.faang.task_49224;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 10;
    private static final int REQUEST_COUNTER = 5;

    public static void main(String[] args) {
        TelegramBot telegramBot = new TelegramBot(REQUEST_COUNTER);
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < 100; i++) {
            String message = "Message №" + i;
            executor.execute(() -> {
                telegramBot.sendMessage(message);
            });
        }

        executor.shutdown();

        try {
            if (executor.awaitTermination(10, TimeUnit.SECONDS)) {
                log.info("All messages have been sent successfully");
            } else {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}
