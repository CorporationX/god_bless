package faang.school.godbless.sprint_3.multithreading_parallelism_thread.task_9_spaceX;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Main {

    private final static int NUMS_THREAD = 1;

    public static void main(String[] args) {
        List<RocketLaunch> rocketLaunchList = createLaunchesList();

        long start = System.currentTimeMillis();
        planRocketLaunches(rocketLaunchList);
        long end = System.currentTimeMillis();

        System.out.printf("Время работы программы: %d\n", end - start);
    }

    private static List<RocketLaunch> createLaunchesList() {
        return new ArrayList<>(List.of(new RocketLaunch("Falcon 9", LocalDateTime.now().plusSeconds(15)),
                new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusSeconds(25)),
                new RocketLaunch("Dragon", LocalDateTime.now().plusMinutes(1))));
    }

    private static void planRocketLaunches(List<RocketLaunch> launches) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(NUMS_THREAD);
        List<RocketLaunch> sortLaunches = launches.stream()
                .sorted(Comparator.comparing(RocketLaunch::timeLaunch))
                .toList();

        for (RocketLaunch launch : sortLaunches) {
            long waitingTime = LocalDateTime.now().until(launch.timeLaunch(), ChronoUnit.MILLIS);
            executor.schedule(launch, waitingTime, TimeUnit.MILLISECONDS);
        }

        executor.shutdown();
        try {
            RocketLaunch lastLaunch = launches.get(launches.size() - 1);
            long waitingTime = LocalDateTime.now().until(lastLaunch.timeLaunch(), ChronoUnit.MILLIS);
            executor.awaitTermination(waitingTime + 3000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
