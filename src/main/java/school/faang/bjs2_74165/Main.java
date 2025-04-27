package school.faang.bjs2_74165;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static java.util.concurrent.TimeUnit.SECONDS;

@Slf4j
public class Main {
    private static final int MAX_EXPECTATION = 60;
    private static final int NUM_THREADS = 5;
    private static final int NUMBER_MESSAGES = 1000000;

    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        IntStream.range(0, NUMBER_MESSAGES)
                .forEach(i -> executorService.execute(() -> bot.sendMessage("msg" + i)));

        gracefullyShutdown(executorService);
    }

    private static void gracefullyShutdown(ExecutorService executorService) {
        executorService.shutdown();
        try {
            boolean isClose = executorService.awaitTermination(MAX_EXPECTATION, SECONDS);
            if (!isClose) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException ex) {
            log.error("thread stoppage error");
            executorService.shutdownNow();
        }
        log.info("All tasks completed");
    }
}
