package school.faang.spacex;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RocketLaunchScheduler {
    public static final long SECOND_IN_MILLIS = 1000;

    public static void planRocketLaunches(List<RocketLaunch> launches) {
        long startTime = System.currentTimeMillis();

        ExecutorService executor = Executors.newSingleThreadExecutor();

        launches.sort(Comparator.comparingLong(RocketLaunch::getLaunchTime));

        long baseTime = System.currentTimeMillis();

        for (RocketLaunch launch : launches) {
            long delay = launch.getLaunchTime() - System.currentTimeMillis();

            if (delay > 0) {
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.printf("⚠️ Ожидание перед запуском \"%s\" было прервано.%n", launch.getName());
                }
            }

            executor.submit(launch::launch);
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(launches.size() * 2, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        long endTime = System.currentTimeMillis();
        System.out.printf("Время выполнения планирования: %d мс%n", (endTime - startTime));
    }

    public static void main(String[] args) {
        List<RocketLaunch> launches = new ArrayList<>();
        long currentTime = System.currentTimeMillis();

        launches.add(new RocketLaunch("Falcon 9", currentTime + 1 * SECOND_IN_MILLIS));
        launches.add(new RocketLaunch("Starship", currentTime + 3 * SECOND_IN_MILLIS));
        launches.add(new RocketLaunch("Falcon Heavy", currentTime + 2 * SECOND_IN_MILLIS));

        planRocketLaunches(launches);
    }
}
