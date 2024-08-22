package faang.school.godbless.thirdsprint.spacex;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Getter
public class SpaceXLaunchScheduler {
    private static final int COUNTDOWN_TIME = 10000;

    private long executionTime;

    public void planRocketLaunches(List<RocketLaunch> launches) {
        long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (RocketLaunch launch : launches) {
            executor.submit(() -> {
                long delay = java.time.Duration.between(LocalDateTime.now(), launch.getLaunchTime()).toMillis();
                System.out.println("Rocket: " + launch.getName() + " | Time to launch: " + delay + " ms");

                try {
                    Thread.sleep(delay - COUNTDOWN_TIME);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                for (int i = 10; i > 0; i--) {
                    System.out.println("Rocket: " + launch.getName() + " | Countdown: " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Rocket: " + launch.getName() + " | Lift off!");

                launch.launchRocket();
            });
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(1, TimeUnit.HOURS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        long endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
    }
}
