package school.faang.broforce;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int COUNT_THREADS = 10;
    private static final int COUNT_GAME_OPERATIONS = 100;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(COUNT_THREADS);
    private static final Game GAME = new Game();
    private static final Random RANDOM = new Random();
    private static final int TIME_EXECUTION = 1;
    private static final TimeUnit TIME_UNIT = TimeUnit.MINUTES;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < COUNT_GAME_OPERATIONS; i++) {
            EXECUTOR.submit(() -> executeWithException(() -> GAME.update(RANDOM.nextBoolean())));
        }
        EXECUTOR.shutdown();
        boolean isTerminated = EXECUTOR.awaitTermination(TIME_EXECUTION, TIME_UNIT);
        if (isTerminated) {
            log.info("All operations executed successfully");
        } else {
            log.warn("Timed out: {} {}", TIME_EXECUTION, TIME_UNIT);
            EXECUTOR.shutdownNow();
        }
    }

    private static void executeWithException(RunnableWithException task) {
        try {
            task.run();
        } catch (InterruptedException exception) {
            log.error("Thread has been interrupted. Thread name: {}\nException: {}\nStack trace: {}",
                    Thread.currentThread().getName(), exception, exception.getStackTrace());
            Thread.currentThread().interrupt();
            EXECUTOR.shutdownNow();
        }
    }
}
