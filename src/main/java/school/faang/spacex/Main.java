package school.faang.spacex;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int MAX_WAIT_MINUTES = 1;

    public static void main(String[] args) {
        List<RocketLaunch> launches = new ArrayList<>(List.of(
                new RocketLaunch("Rocket 1", System.currentTimeMillis() + 2000),
                new RocketLaunch("Rocket 2", System.currentTimeMillis() + 4000),
                new RocketLaunch("Rocket 3", System.currentTimeMillis() + 6000),
                new RocketLaunch("Rocket 4", System.currentTimeMillis() + 500),
                new RocketLaunch("Rocket 5", System.currentTimeMillis() + 4000),
                new RocketLaunch("Rocket 6", System.currentTimeMillis() + 10000)
        ));

        planRocketLaunches(launches);
    }

    public static void planRocketLaunches(List<RocketLaunch> launches) {
        long startTime = System.currentTimeMillis();

        launches.sort(Comparator.comparingLong(RocketLaunch::getLaunchTime));

        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
            for (RocketLaunch launch : launches) {
                long delay = launch.getLaunchTime() - System.currentTimeMillis();
                if (delay > 0) {
                    Thread.sleep(delay);
                }
                executor.execute(launch::launch);
            }
        } catch (InterruptedException e) {
            log.warn("Планирование прервано");
            Thread.currentThread().interrupt();
        } finally {
            gracefullyShutdown(executor);
        }

        log.info("Общее время запуска: {} мс", System.currentTimeMillis() - startTime);
    }

    private static void gracefullyShutdown(ExecutorService executor) {
        executor.shutdown();
        try {
            if (executor.awaitTermination(MAX_WAIT_MINUTES, TimeUnit.MINUTES)) {
                log.info("Все заупски завершены");
            } else {
                log.error("Не все запуски завершены за {} минут. Завершаем принудительно...", MAX_WAIT_MINUTES);
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.warn("Ожидание завершения запуска прервано.");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
