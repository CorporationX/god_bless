package school.faang.task_48259;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class RocketLaunchSystem {
    public void planRocketLaunches(List<RocketLaunch> launches) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        long launchesStartTime = System.currentTimeMillis();

        try {
            for (RocketLaunch rocketLaunch : launches) {
                long delay = rocketLaunch.getLaunchTime() - System.currentTimeMillis();
                if (delay > 0) {
                    Thread.sleep(delay);
                }
                executorService.execute(rocketLaunch::launch);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        executorService.shutdown();

        long launchesEndTime = System.currentTimeMillis();

        log.info("Total time to complete the launches: {}", launchesEndTime - launchesStartTime);
    }
}
