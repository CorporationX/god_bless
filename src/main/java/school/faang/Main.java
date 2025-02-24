package school.faang;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int TIMEOUT_SECONDS = 30;

    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot(0, LocalDateTime.now());
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; ++i) {
            String message = "message " + i;
            executor.submit(() -> bot.sendMessage(message));
        }
        executor.shutdown();

        try {
            if (!executor.awaitTermination(TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                log.error("Not all tasks have been completed on time.");
            }
        } catch (InterruptedException e) {
            log.error("awaitTermination was interrupted.");
            executor.shutdownNow();
            throw new RuntimeException(e);
        }
        log.info("All messages have been sent.");
    }
}
