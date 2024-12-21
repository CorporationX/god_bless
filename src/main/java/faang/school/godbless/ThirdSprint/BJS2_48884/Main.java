package faang.school.godbless.ThirdSprint.BJS2_48884;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        List<RocketLaunch> launches = List.of(new RocketLaunch("Falcon 9", LocalDateTime.now().plusSeconds(2)),
                new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusSeconds(4)),
                new RocketLaunch("Dragon", LocalDateTime.now().plusSeconds(10)));

        long startTime = System.currentTimeMillis();
        try {
            planRocketLaunches(launches);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Planning interrupted");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) + " ms");
    }

    public static void planRocketLaunches(List<RocketLaunch> launches) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (RocketLaunch rocket : launches) {
            long delay = Duration.between(LocalDateTime.now(), rocket.getLaunchTime()).toMillis();
            if (delay > 0) {
                Thread.sleep(delay);
            }
            executor.submit(rocket::launch);
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            executor.awaitTermination(1, TimeUnit.SECONDS);
        }
    }
}

