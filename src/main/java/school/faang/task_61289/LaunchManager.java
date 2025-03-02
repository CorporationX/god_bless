package school.faang.task_61289;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class LaunchManager {
    public static final int LAUNCH_PREPARE_TIME = 1000;
    public static final int EXTRA_TIME = 1000;

    public void planRocketLaunches(List<RocketLaunch> launches) {
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.printf("Current time: %s Rockets are prepared for launching.\n", currentTime);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
            long maxTime = launches.get(launches.size() - 1).getLaunchTime().getSecond() + EXTRA_TIME;
            for (RocketLaunch rocket : launches) {

                Duration delay = Duration.between(LocalDateTime.now(), rocket.getLaunchTime());
                long milliSecondsDelay = delay.toMillis() - LAUNCH_PREPARE_TIME;
                if (milliSecondsDelay > 0) {
                    Thread.sleep(milliSecondsDelay);
                }
                executor.submit(() -> {
                    try {
                        rocket.launch();
                    } catch (RuntimeException e) {
                        log.info("Launch of {} was interrupted.", rocket.getName());
                    }
                });
            }
            executor.shutdown();
            boolean terminated = executor.awaitTermination(maxTime, TimeUnit.SECONDS);
            if (!terminated) {
                System.err.println("Tasks did not complete within the specified timeout.");
            }
        } catch (InterruptedException e) {
            System.out.println("Planning process was interrupted.");
        }
    }
}
