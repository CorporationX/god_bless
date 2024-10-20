package school.faang.Mnogopotochka.ParallelismThread.BJS2_36278;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Getter
@AllArgsConstructor
public class RocketLaunch {
    private static final Logger log = LoggerFactory.getLogger(RocketLaunch.class);
    private String name;
    private int launchTime;

    public static void planRocketLaunches(List<RocketLaunch> launches) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        long startTimeLaunches = System.currentTimeMillis();
        try {
            launches.forEach(launch -> {
                try {
                    Thread.sleep(launch.getLaunchTime());
                    executorService.submit(launch::launch);
                } catch (InterruptedException e) {
                    log.warn("Thread interrupted", e);
                }
            });
        } finally {
            executorService.shutdown();
            try {
                if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                    executorService.shutdownNow();
                }
            } catch (InterruptedException e) {
                executorService.shutdownNow();
            }
            long endTimeLaunches = System.currentTimeMillis();
            log.info("Время выполнения: {} ms", (endTimeLaunches - startTimeLaunches));
        }
    }

    private void launch() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.warn("Thread interrupted", e);
        }
        log.info("Запуск ракеты: {}", name);
    }
}
