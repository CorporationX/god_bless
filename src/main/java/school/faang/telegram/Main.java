package school.faang.telegram;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    private static final int TIME_OUT = 20;
    private static final int NUMBER_OF_MESSAGES = 100;

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(6);
        TelegramBot telegramBot = new TelegramBot();

        for (int i = 0; i < NUMBER_OF_MESSAGES; i++) {
            int finalI = i;
            executor.submit(() -> telegramBot.sendMessage(finalI + "message about marvelous things"));
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIME_OUT, TimeUnit.SECONDS)) {
                log.warn("Потоки не завершены за выделенное время. Завершаю принудительно...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Потоки прерваны во время ожидания их завершения: ", e);
            executor.shutdownNow();
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
