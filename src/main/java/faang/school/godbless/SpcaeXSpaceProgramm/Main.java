package faang.school.godbless.SpcaeXSpaceProgramm;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        LocalDateTime baseTime = LocalDateTime.now().with(LocalTime.of(5, 0));

        List<RocketLaunch> launches = List.of(
                new RocketLaunch("Rocket1", baseTime.plusHours(1)),
                new RocketLaunch("Rocket2", baseTime.plusHours(2)),
                new RocketLaunch("Rocket3", baseTime.plusHours(3)),
                new RocketLaunch("Rocket4", baseTime.plusHours(4)),
                new RocketLaunch("Rocket5", baseTime.plusHours(5))
        );

        long startTime = System.currentTimeMillis();
        planRocketLaunches(launches);
        System.out.println(System.currentTimeMillis() - startTime);

    }

    public static void planRocketLaunches(List<RocketLaunch> rocketLaunches) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        List<RocketLaunch> rocketLaunchesSortedByDate = rocketLaunches.stream()
                .sorted(Comparator.comparing(RocketLaunch::getStartTime))
                .toList();
        for (RocketLaunch rocketLaunch : rocketLaunchesSortedByDate) {
            executorService.submit(rocketLaunch::launch);
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            System.out.println("no dota toda i guess. just armaggedon 'cause of us");
            throw new RuntimeException(e);
        }
        System.out.println("all rockets launched, now we can play dota 2");
    }
}
