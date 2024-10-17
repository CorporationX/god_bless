package school.faang.spacex;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class RockerLaunchPlanner {

    public void planRocketLaunches(List<RocketLaunch> launches) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        launches.stream()
                .sorted(Comparator.comparingLong(RocketLaunch::getLaunchTime))
                .forEach(launch -> {
                    long currentTime = System.currentTimeMillis();
                    long delay = Math.max(launch.getLaunchTime() - currentTime, 0);

                    executor.submit(() -> {
                        try {
                            Thread.sleep(delay);
                            launch.launch();
                        } catch (InterruptedException e) {
                            log.error(e.getMessage());
                            log.error(Arrays.toString(e.getStackTrace()));
                            Thread.currentThread().interrupt();
                        }
                    });
                });

        executor.shutdown();
        try {
            if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Все ракеты были успешно запущены!");
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            log.error(Arrays.toString(e.getStackTrace()));
            Thread.currentThread().interrupt();
        }
    }
}
