package faang.school.godbless.BJS2_1230;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        // Example usage
        List<RocketLaunch> rocketLaunches = new ArrayList<>();
        rocketLaunches.add(new RocketLaunch("Mission Alpha", LocalDateTime.now().plusSeconds(5)));
        rocketLaunches.add(new RocketLaunch("Mission Bravo", LocalDateTime.now().plusSeconds(10)));
        rocketLaunches.add(new RocketLaunch("Mission Charlie", LocalDateTime.now().plusSeconds(15)));

        long startTime = System.currentTimeMillis();
        planRocketLaunches(rocketLaunches);
        long endTime = System.currentTimeMillis();

        System.out.println("Time taken to rocket launches: " + (endTime - startTime) + " milliseconds");
    }

    public static void planRocketLaunches(List<RocketLaunch> rocketLaunches) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        for (RocketLaunch rocketLaunch : rocketLaunches) {
            long delay = calculateDelay(rocketLaunch.getLaunchTime());
            executor.schedule(rocketLaunch::launch, delay, TimeUnit.MILLISECONDS);
        }

        executor.shutdown();

        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private static long calculateDelay(LocalDateTime launchTime) {
        return LocalDateTime.now().until(launchTime, ChronoUnit.MINUTES);
    }
}