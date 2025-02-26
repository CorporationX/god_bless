package school.faang;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUMS_THREAD = 7;

    public static void main(String[] args) {
        TelegramBot telegramBot = new TelegramBot();
        ExecutorService executor = Executors.newFixedThreadPool(NUMS_THREAD);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < NUMS_THREAD; j++) {
                final int a = i;
                executor.submit(() -> telegramBot.sendMessage("message" + a));
            }
        }
        executor.shutdown();

        try {
            if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
                executor.shutdownNow();
                log.error("Not all tasks have been completed on time.");
            }
        } catch (InterruptedException e) {
            log.error("awaitTermination was interrupted.");
            executor.shutdownNow();
            throw new RuntimeException(e);
        }
        log.info("All messages have been sent");
    }
}
