package school.faang.godbless.bjs2_36289;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Launcher {
    private static final Launcher INSTANCE = new Launcher();

    private Launcher() {
    }

    public static Launcher getInstance() {
        return INSTANCE;
    }

    public void planRocketLaunches(List<RocketLaunch> launches) {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        long methodStartTime = System.currentTimeMillis();
        for (RocketLaunch launch : launches) {
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
        pool.shutdown();
        log.info("planRocketLaunches method execution time: {} ms", System.currentTimeMillis() - methodStartTime);
    }
}
