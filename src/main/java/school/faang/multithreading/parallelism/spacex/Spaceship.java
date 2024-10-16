package school.faang.multithreading.parallelism.spacex;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Spaceship {
    public static void main(String[] args) {
        List<RocketLaunch> launches = Arrays.asList(
                new RocketLaunch("Rocket1", LocalDateTime.now().plusSeconds(5)),
                new RocketLaunch("Rocket2", LocalDateTime.now().plusSeconds(10)),
                new RocketLaunch("Rocket3", LocalDateTime.now().plusSeconds(15)),
                new RocketLaunch("Rocket4", LocalDateTime.now().plusSeconds(20))
        );

        launches.sort(Comparator.comparing(RocketLaunch::getLaunchTime));

        long startTime = System.currentTimeMillis();
        planRocketLaunches(launches);
        long endTime = System.currentTimeMillis();

        log.info("Все ракеты запустились за {} ms", endTime - startTime);
    }

    @SneakyThrows
    public static void planRocketLaunches(List<RocketLaunch> launches) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (RocketLaunch rocketLaunch : launches) {
            long delay = ChronoUnit.MILLIS.between(LocalDateTime.now(), rocketLaunch.getLaunchTime());
            Thread.sleep(delay);
            executor.submit(rocketLaunch::launch);
        }

        executor.shutdown();
        executor.awaitTermination(2, TimeUnit.MINUTES);
    }
}
