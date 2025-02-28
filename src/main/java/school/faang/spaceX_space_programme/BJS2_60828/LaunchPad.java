package school.faang.spaceX_space_programme.BJS2_60828;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class LaunchPad {
    private final ExecutorService poolThread = Executors.newSingleThreadExecutor();

    public void planRocketLaunches(@NonNull List<RocketLaunch> launches) {
        launches.forEach(rocketLaunch -> {
            long delay = rocketLaunch.getLaunchTime() - System.currentTimeMillis();
            if (delay > 0) {
                try {
                    Thread.sleep(delay);
                    poolThread.submit(rocketLaunch::launch);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.warn("Выполнение задачи прервано {}", e.getMessage());
                }
            }
        });

        poolThread.shutdown();
        try {
            if (!poolThread.awaitTermination(1, TimeUnit.MINUTES)) {
                poolThread.shutdownNow();
            }
        } catch (InterruptedException e) {
            poolThread.shutdownNow();
        }
    }
}
