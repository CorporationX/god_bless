package faang.school.godbless.BJS25695;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SpaceXRocketPlanner {
    public static long planRocketLaunches(List<RocketLaunch> launches) {
        long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (RocketLaunch launch : launches) {
            long delay = launch.getLaunchTime() - System.currentTimeMillis();
            executor.submit(() -> {
                try {
                    Thread.sleep(delay);
                    launch.launch();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {
        List<RocketLaunch> launches = List.of(
                new RocketLaunch("Falcon 9", System.currentTimeMillis() + 2000),
                new RocketLaunch("Falcon Heavy", System.currentTimeMillis() + 5000),
                new RocketLaunch("Starship", System.currentTimeMillis() + 8000)
        );

        long executionTime = planRocketLaunches(launches);
        System.out.println("Время выполнения метода planRocketLaunches: " + executionTime + " мс");
    }
}
