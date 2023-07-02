package faang.school.godbless.sprint4.spaceProgramSpaceX.classes;

import lombok.AllArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class RocketLaunch {
    private String rocketName;
    private LocalDateTime timeOfLaunch;

    public void launch() {
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(rocketName + " launched");
    }

    public static void planRocketLaunches(List<RocketLaunch> launches) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        launches = launches.stream()
                .sorted(Comparator.comparing(a -> a.timeOfLaunch))
                .toList();

        long start = System.currentTimeMillis();

        for (RocketLaunch launch : launches) {
            LocalDateTime now = LocalDateTime.now();
            Duration duration = Duration.between(now, launch.timeOfLaunch);
            long millis = duration.toMillis();
            executor.schedule(launch::launch, millis, TimeUnit.MILLISECONDS);
        }
        executor.shutdown();
        try {
            if (executor.awaitTermination(20, TimeUnit.SECONDS)) {
                System.out.println("All launches are completed");
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " is interrupted");
            Thread.currentThread().interrupt();
        }
        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}