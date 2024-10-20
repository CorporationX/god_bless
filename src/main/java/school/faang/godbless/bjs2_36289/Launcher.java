package school.faang.godbless.bjs2_36289;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Launcher {
    public static void planRocketLaunches(List<RocketLaunch> launches) {
        List<ExecutorService> pools = new ArrayList<>();
        long methodStartTime = System.currentTimeMillis();
        for (RocketLaunch launch : launches) {
            ExecutorService pool = Executors.newSingleThreadExecutor();
            pools.add(pool);
            pool.submit(() -> {
                try {
                    Thread.sleep(launch.getLaunchTimeMillis());
                } catch (InterruptedException e) {
                    log.warn("Interrupted while waiting to launch");
                    Thread.currentThread().interrupt();
                }
                launch.launch();
            });
        }
        pools.forEach(ExecutorService::shutdown);
        log.info("planRocketLaunches method execution time: {} ms", System.currentTimeMillis() - methodStartTime);
    }
}
