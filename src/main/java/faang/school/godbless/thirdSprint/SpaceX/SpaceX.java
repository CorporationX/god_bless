package faang.school.godbless.thirdSprint.SpaceX;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SpaceX {
    public static void main(String[] args) {
        List<RocketLaunch> launches = List.of(
                new RocketLaunch("Falcon 9", LocalDateTime.now().plusMinutes(2)),
                new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusMinutes(5)),
                new RocketLaunch("Dragon", LocalDateTime.now().plusMinutes(10))
        );

        long before = System.currentTimeMillis();
        planRocketLaunches(launches);
        long after = System.currentTimeMillis();
        System.out.println(after - before);
    }

    public static void planRocketLaunches(List<RocketLaunch> launches) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        launches = launches.stream()
                .sorted(Comparator.comparing(RocketLaunch::launchTime))
                .toList();

        for (RocketLaunch rocketLaunch : launches) {
            service.submit(rocketLaunch::launch);
        }
        service.shutdown();

        try {
            service.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
