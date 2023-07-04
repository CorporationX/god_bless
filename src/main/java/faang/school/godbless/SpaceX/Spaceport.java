package faang.school.godbless.SpaceX;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Spaceport {
    public static void main(String[] args) throws InterruptedException {

        List<RocketLaunch> rocketLaunches = new ArrayList<>();
        rocketLaunches.add(new RocketLaunch("Falcon 9", LocalDateTime.now().plusSeconds(15)));
        rocketLaunches.add(new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusSeconds(10)));
        rocketLaunches.add(new RocketLaunch("Dragon", LocalDateTime.now().plusSeconds(50)));

        planRocketLaunches(rocketLaunches);

    }

    public static void planRocketLaunches(List<RocketLaunch> rocketLaunches) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Instant start = Instant.now();

        rocketLaunches.stream().sorted((r1, r2) -> r1.getLaunchTime().compareTo(r2.getLaunchTime())).forEach(rocketLaunch -> executor.submit(rocketLaunch));
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);

        Instant finish = Instant.now();
        long spent = Duration.between(start, finish).toMillis();
        System.out.println("Затрачено времени на запуск, мс: " + spent);
    }
}
