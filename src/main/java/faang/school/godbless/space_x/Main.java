package faang.school.godbless.space_x;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        List<RocketLaunch> rocketLaunches = List.of(
                new RocketLaunch("test1", LocalDateTime.now().plusSeconds(10)),
                new RocketLaunch("test1", LocalDateTime.now().plusSeconds(15)),
                new RocketLaunch("test1", LocalDateTime.now().plusSeconds(20))
        );
        System.out.printf("%s -> execution time in seconds", planRocketLaunches(rocketLaunches));
    }

    public static long planRocketLaunches(List<RocketLaunch> launches) {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        long startTime = System.currentTimeMillis();
        for (RocketLaunch launch : launches) {
            long delay = launch.getLocalDateTime().minusSeconds(LocalDateTime.now().getSecond()).getSecond();
            executorService.schedule(
                    launch::launch,
                    delay,
                    TimeUnit.SECONDS
            );
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(100, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }

        return TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - startTime);
    }
}