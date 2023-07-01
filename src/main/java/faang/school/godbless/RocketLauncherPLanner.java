package faang.school.godbless;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RocketLauncherPLanner {

    public static void main(String[] args) {
        List<RocketLaunch> rocketLaunches = List.of(
                new RocketLaunch("Falcon 9", System.currentTimeMillis() + 5000),
                new RocketLaunch("Falcon Heavy", System.currentTimeMillis() + 6000),
                new RocketLaunch("Starship", System.currentTimeMillis() + 7000)
        );

        long startTime = System.currentTimeMillis();
        planRocketLaunches(rocketLaunches);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("Total execution time: " + executionTime + " milliseconds");
    }


    public static void planRocketLaunches(List<RocketLaunch> rocketLaunches) {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        for (RocketLaunch rocketLaunch : rocketLaunches) {
            long delay = rocketLaunch.getLaunchTime() - System.currentTimeMillis();
            if (delay > 0) {
                executorService.schedule(rocketLaunch::launch, delay, TimeUnit.MILLISECONDS);
            } else {
                System.out.println("Launch time already passed for rocket: " + rocketLaunch.getName());
            }
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
