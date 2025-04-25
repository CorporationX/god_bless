package school.faang.bjs2_73534;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final long MINUTES_TO_AWAIT = 5;
    private static final int PLAYER_COUNT = 15;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Boss boss = new Boss(3);

        IntStream.range(0, PLAYER_COUNT)
            .forEach(operand ->
                executor.execute(
                    () -> new Player("player #%d".formatted(operand)).doBattle(boss)
                )
            );

        gracefullyShutdown(executor);
    }

    private static void gracefullyShutdown(ExecutorService executor) {
        executor.shutdown();
        try {
            if (executor.awaitTermination(MINUTES_TO_AWAIT, TimeUnit.MINUTES)) {
                log.info("All tasks are completed.");
            } else {
                List<Runnable> notExecuted = executor.shutdownNow();
                log.info("{} tasks failed to start.", notExecuted.size());
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            throw new RuntimeException(e);
        }
    }
}
