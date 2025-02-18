package bjs2_56245;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LaunchScheduler {
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
                        throw new RuntimeException(e);
                    }
                });
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Planning interrupted");
        } finally {
            executor.shutdown();
            try {
                if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                executor.shutdownNow();
            }
        }
    }
}
