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
    private static final int MAX_EXPECTATION = 60;

    public void planRocketLaunches(List<RocketLaunch> launches) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        LocalDateTime start = now();

        launches.forEach(launch -> executorService.execute(() -> planRocketLaunch(launch, start)));

        gracefullyShutdown(executorService);

        long end = Duration.between(start, now()).toMillis();
        log.info("Planning is complete: {}", now());
        log.info("Total execution time: {} мс", end);
    }

    private static void gracefullyShutdown(ExecutorService executorService) {
        executorService.shutdown();
        log.info("Thread main is blocked");
        try {
            boolean isClose = executorService.awaitTermination(MAX_EXPECTATION, SECONDS);
            if (!isClose) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException ex) {
            log.error("thread stoppage error");
            executorService.shutdownNow();
        }
        log.info("Thread main is unlocked");
    }

    private void planRocketLaunch(RocketLaunch launch, LocalDateTime start) {
        long delay = Duration.between(start, launch.launchTime()).toMillis();
        if (delay > 0) {
            try {
                Thread.sleep(delay);
                log.info("Launch delays have begun for the rocket {}", launch.name());
            } catch (InterruptedException ex) {
                log.error("thread stoppage error");
                Thread.currentThread().interrupt();
            }
        }
        launch.launch();
    }
}
