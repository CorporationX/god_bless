package school.faang.sprint_3.bjs2_37266_telegramBot;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int THREADS_COUNT = 5;

    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();
        ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);

        IntStream.range(0, 81)
                .forEach(i -> executor.submit(
                        () -> bot.sendMessage("Message " + i))
                );

        executor.shutdown();
        try {
            if (!executor.awaitTermination(3, TimeUnit.MINUTES)) {
                log.info("Something went wrong, shutdown now!");
                executor.shutdownNow();
            } else {
                log.info("Task completed!");
            }
        } catch (InterruptedException e) {
            log.error("An error occurred while threads shutting down", e);
            throw new IllegalStateException(e);
        }
    }
}
