package school.faang.bjs248548;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@AllArgsConstructor
@Getter
public class RocketLaunch {
    private static final int LAUNCH_DELAY = 1000;
    private final String name;
    private final LocalDateTime launchTime;

    public Long getLaunchTimeMillis() {
        return launchTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public void launch() {
        sleep(String.format("Launch %s", name));
        log.info("Launching {}, is finished", name);
    }

    public static void planRocketLaunches(List<RocketLaunch> launches) {
        long start = System.currentTimeMillis();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        launches.forEach(rocket -> {
            long delay = rocket.getLaunchTimeMillis() - System.currentTimeMillis();
            try {
                if (delay > 0) {
                    Thread.sleep(delay);
                }
                executor.submit(rocket::launch);
                log.info("Rocket {} launch planed in {} ms", rocket.name, delay);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
        });
        shutdown(executor);

        log.info("Launch time: {} ms", System.currentTimeMillis() - start);
    }

    private static void shutdown(ExecutorService executor) {
        executor.shutdown();
        while (!executor.isTerminated()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
        }
    }

    private static void sleep(String messagePrefix) {
        try {
            Thread.sleep(LAUNCH_DELAY);
        } catch (InterruptedException e) {
            log.error("{} terminated, error: {}", messagePrefix, e.getMessage());
        }
    }
}
