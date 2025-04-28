package school.faang.spacex;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RocketLaunchScheduler {
    public static void planRocketLaunches(List<RocketLaunch> launches) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        launches.sort(Comparator.comparingLong(RocketLaunch::getLaunchTime));

        long baseTime = System.currentTimeMillis();

        for (RocketLaunch launch : launches) {
            long delay = launch.getLaunchTime() - (System.currentTimeMillis() - baseTime);

            if (delay > 0) {
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Ожидание перед запуском " + launch.getName() + " было прервано.");
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
        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        System.out.printf("Время выполнения планирования: %d мс%n", (endTime - startTime));
    }

    public static void main(String[] args) {
        List<RocketLaunch> launches = new ArrayList<>();
        long currentTime = System.currentTimeMillis();

        launches.add(new RocketLaunch("Falcon 9", 1000));
        launches.add(new RocketLaunch("Starship", 3000));
        launches.add(new RocketLaunch("Falcon Heavy", 2000));

        planRocketLaunches(launches);
    }
}
