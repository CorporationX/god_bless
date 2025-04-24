package school.faang.bjs2_72494;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.time.LocalDateTime.now;
import static java.util.concurrent.TimeUnit.SECONDS;

@NoArgsConstructor
@Slf4j
public class RocketLaunchService {
    private static final int max_expectation
    public void planRocketLaunches(List<RocketLaunch> launches) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        LocalDateTime start = now();

        launches.forEach(launch -> executorService.execute(() -> planRocketLaunch(launch, start)));

        gracefullyShutdown(executorService);

        log.info("Thread main is unlocked");

        long end = Duration.between(start, now()).toMillis();
        log.info(String.format("Planning is complete: %s", now()));
        log.info(String.format("Total execution time: %d мс", end));
    }

    private static void gracefullyShutdown(ExecutorService executorService) {
        executorService.shutdown();
        try {
            log.info("Thread main is blocked");
            boolean isClose = executorService.awaitTermination(60, SECONDS);
            if (!isClose) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException ex) {
            log.error("thread stoppage error");
            Thread.currentThread().interrupt();
        }
    }

    private void planRocketLaunch(RocketLaunch launch, LocalDateTime start) {
        long delay = Duration.between(start, launch.launchTime()).toMillis();
        if (delay > 0) {
            try {
                Thread.sleep(delay);
                log.info(String.format("Launch delays have begun for the rocket %s", launch.name()));
            } catch (InterruptedException ex) {
                log.error("thread stoppage error");
                Thread.currentThread().interrupt();
            }
        }
        launch.launch();
    }
}
