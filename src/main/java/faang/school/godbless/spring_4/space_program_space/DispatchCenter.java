package faang.school.godbless.spring_4.space_program_space;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class DispatchCenter {
    private static final ExecutorService POOL = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {

        List<RocketLaunch> rockets = List.of(
                new RocketLaunch("Water rocket", 23), new RocketLaunch("Flight to mars", 16),
                new RocketLaunch("Quick berry", 18), new RocketLaunch("For watermelons", 10)
        );

        long startTime = System.currentTimeMillis();

        planRocketLaunches(rockets);
        POOL.shutdown();
        try {
            if (!POOL.awaitTermination(6, TimeUnit.SECONDS)) {
                POOL.shutdownNow();
            }
        } catch (InterruptedException e) {
            POOL.shutdownNow();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Time: " + (endTime - startTime));
    }

    private static void planRocketLaunches(List<RocketLaunch> rockets) {
        rockets = rockets.stream().sorted((Comparator.comparing(RocketLaunch::getLaunchTime))).collect(Collectors.toList());
        rockets.forEach(POOL::submit);
    }
}
