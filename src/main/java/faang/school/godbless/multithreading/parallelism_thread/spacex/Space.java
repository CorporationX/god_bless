package faang.school.godbless.multithreading.parallelism_thread.spacex;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Space {

    public static void main(String[] args) {
        List<RocketLaunch> rocketLaunch = List.of(
                new RocketLaunch("Rocket 1", LocalDateTime.now().plusSeconds(2)),
                new RocketLaunch("Rocket 2", LocalDateTime.now().plusSeconds(5)),
                new RocketLaunch("Rocket 3", LocalDateTime.now().plusSeconds(7)),
                new RocketLaunch("Rocket 4", LocalDateTime.now().plusSeconds(20))
        );
        planRocketLaunches(rocketLaunch);
    }

    public static void planRocketLaunches(List<RocketLaunch> rocketLaunch) {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (int i = 0; i < rocketLaunch.size(); i++) {
            int finalI = i;
            var launchTime = rocketLaunch.get(finalI).getLaunchTime().toEpochSecond(java.time.ZoneOffset.UTC)
                    - LocalDateTime.now().toEpochSecond(java.time.ZoneOffset.UTC);
            try {
                Thread.sleep(launchTime * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            executor.execute(() -> rocketLaunch.get(finalI).launch());
        }
        executor.shutdown();
    }
}
