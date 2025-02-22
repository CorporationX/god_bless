package space;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class LaunchPlanner {
    public void planRocketLaunches(List<RocketLaunch> launches) {

        launches.sort(Comparator.comparingLong(RocketLaunch::getLaunchTime));

        long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (RocketLaunch launch : launches) {
            long elapsed = System.currentTimeMillis() - startTime;
            long computedDelay = launch.getLaunchTime() - elapsed;
            final long delay = (computedDelay < 0) ? 0 : computedDelay;
            executor.submit(() -> {
                try {
                    if (delay > 0) {
                        Thread.sleep(delay);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                launch.launch();
            });
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                log.warn("Not all rocket launches finished in the expected time.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Launch planning interrupted.", e);
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        long endTime = System.currentTimeMillis();
        log.info("Total planning time: {} ms", (endTime - startTime));
    }
}
