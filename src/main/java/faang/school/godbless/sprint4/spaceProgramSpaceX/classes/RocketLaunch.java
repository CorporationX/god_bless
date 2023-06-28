package faang.school.godbless.sprint4.spaceProgramSpaceX.classes;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
        long start = System.currentTimeMillis();

        ExecutorService executor = Executors.newSingleThreadExecutor();

        launches = launches.stream()
                .sorted(Comparator.comparing(a -> a.timeOfLaunch))
                .toList();

        for (RocketLaunch launch : launches) {
            while (!executor.isTerminated()) {
                LocalDateTime now = LocalDateTime.now();
                while (now.isAfter(launch.timeOfLaunch)) {
                    executor.submit(launch::launch);
                }
            }
        }

        executor.shutdown();
    }
}