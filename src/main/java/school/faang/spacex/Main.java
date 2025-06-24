package school.faang.spacex;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Danil Pudovkin
 * @since 22.06.2025
 */
@Slf4j(topic = "Main")
public class Main {

    private static final int MAX_EXECUTOR_AWAIT_TERMINATION_TIME = 10;
    private static final ExecutorService EXECUTOR = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
        var launches = List.of(
                new RocketLaunch("Launch 1", 200),
                new RocketLaunch("Launch 2", 400),
                new RocketLaunch("Launch 3", 600),
                new RocketLaunch("Launch 4", 800),
                new RocketLaunch("Launch 5", 1000)
        );
        benchmark(() -> SpaceCenter.planRocketLaunches(EXECUTOR, launches));
        EXECUTOR.shutdown();
        try {
            if (!EXECUTOR.awaitTermination(MAX_EXECUTOR_AWAIT_TERMINATION_TIME, TimeUnit.SECONDS)) {
                EXECUTOR.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            EXECUTOR.shutdownNow();
        }
    }

    private static void benchmark(Runnable action) {
        long start = System.currentTimeMillis();
        action.run();
        long end = System.currentTimeMillis();
        log.info("Общее время выполнения: {}ms", (end - start));
    }
}
