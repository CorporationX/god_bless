package school.faang.spacex;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        log.info("Start planning");
        planLaunches(List.of(
                new RocketLaunch("SATURN", System.currentTimeMillis() + 10000),
                new RocketLaunch("STARSHIP", System.currentTimeMillis() + 15000),
                new RocketLaunch("HEAVY", System.currentTimeMillis() + 30000)));
        log.info("Finish planning. Total planning time: {} ms", System.currentTimeMillis() - startMillis);
    }

    private static void planLaunches(List<RocketLaunch> launches) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        launches.forEach(scheduledLaunch -> executor.submit(scheduledLaunch::launch));
        executor.shutdown();

        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
