package school.faang.task_49216;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 10;
    private static final int NUM_MESSAGES = 100;

    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        IntStream.range(0, NUM_MESSAGES)
                .forEach(i -> executor.execute(() -> bot.sendMessage("message-" + i)));

        executor.shutdown();

        try {
            if (executor.awaitTermination(10, TimeUnit.SECONDS)) {
                log.info("Task completed successfully");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
