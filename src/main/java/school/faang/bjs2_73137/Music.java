package school.faang.bjs2_73137;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Music {
    private static final long MINUTES_TO_AWAIT = 5;
    private static final int MIN_INDEX_VALUE = 0;
    private static final int MAX_INDEX_VALUE = 3;
    private static final int THREAD_POOL = 5;
    private static final int MAX_THREAD_COUNT = 200;

    public static void main(String[] args) {
        Player player = new Player();
        List<Runnable> playerActions = List.of(
            player::play,
            player::pause,
            player::skip,
            player::previous
        );

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL);
        IntStream.range(0, MAX_THREAD_COUNT)
            .forEach(value -> {
                executor.execute(playerActions.get(getIndex()));
            });
        executor.shutdown();

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

    private static int getIndex() {
        double dbl = Math.random() / Math.nextDown(1.0);
        return (int) Math.round(MIN_INDEX_VALUE * (1.0 - dbl) + MAX_INDEX_VALUE * dbl);
    }
}
