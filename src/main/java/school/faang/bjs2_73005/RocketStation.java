package school.faang.bjs2_73005;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class RocketStation {
    private static final int TERMINATION_TIMEOUT = 1;

    public void planRocketLaunches(List<RocketLaunch> launches) {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        launches.forEach(launch -> executorService.schedule(launch::launch,
                launch.launchTime() - System.currentTimeMillis(), TimeUnit.MILLISECONDS));
        dispose(executorService);
    }

    private void dispose(ExecutorService executorService) {
        log.info("Start disposing");
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TERMINATION_TIMEOUT, TimeUnit.MINUTES)) {
                log.warn("Not all tasks finished successfully");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Interrupted exception with message {} was thrown", e.getMessage());
            executorService.shutdownNow();
        }
    }
}