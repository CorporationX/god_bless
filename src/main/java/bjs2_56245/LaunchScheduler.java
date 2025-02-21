package bjs2_56245;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LaunchScheduler {
    private static final int WAIT_TERMINATION_TIMEOUT_SECONDS = 5;

    private static final Logger logger = LoggerFactory.getLogger(LaunchScheduler.class);

    public static void planRocketLaunches(List<RocketLaunch> launches) {
        Iterator<RocketLaunch> launchesIterator = launches.stream()
                .sorted(Comparator.comparing(RocketLaunch::launchTime))
                .iterator();

        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
            while (launchesIterator.hasNext()) {
                RocketLaunch rocket = launchesIterator.next();
                long delay = rocket.launchTime().toInstant().toEpochMilli() - System.currentTimeMillis();
                if (delay > 0) {
                    Thread.sleep(delay);
                }

                executor.submit(() -> {
                    try {
                        rocket.launch();
                    } catch (InterruptedException e) {
                        logger.error("Запуск ракеты {} прерван", rocket.name(), e);
                        Thread.currentThread().interrupt();
                    }
                });
            }
        } catch (InterruptedException e) {
            logger.error("Запуск ракет прерван", e);
            Thread.currentThread().interrupt();
        } finally {
            executor.shutdown();
            try {
                if (!executor.awaitTermination(WAIT_TERMINATION_TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                executor.shutdownNow();
            }
        }
    }
}
