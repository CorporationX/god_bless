package faang.school.godbless.alexbulgakoff.multithreading.parallelism.spacex;

import lombok.SneakyThrows;

import java.time.Duration;
import java.time.Instant;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Alexander Bulgakov
 */

public class SpaceX {

    public static void main(String[] args) {
        List<RocketLaunch> launches = List.of(new RocketLaunch("Falcon1", 2),
                new RocketLaunch("Falcon2", 5), new RocketLaunch("Falcon3", 9));

        planRocketLaunches(launches);
    }

    @SneakyThrows
    public static void planRocketLaunches(List<RocketLaunch> launches) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        List<RocketLaunch> sortedLaunchesByTime = launches.stream().sorted(Comparator.comparingInt(RocketLaunch::getLaunchTime)).toList();

        Instant start = Instant.now();

        for (RocketLaunch launch : sortedLaunchesByTime) {
            executorService.submit(launch);
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

        Instant end = Instant.now();

        System.out.println("затрачено времени на выполнение: " + Duration.between(start, end).toMillis());
    }
}
