package school.faang.bjs2_72888;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@ToString
public class RocketLaunch {
    private final String name;
    private final long launchTime;
    private long sleepTime = 4_000;

    public RocketLaunch(String name, long launchTime) {
        this.name = name;
        if (launchTime < System.currentTimeMillis()) {
            throw new IllegalArgumentException("Launch time cannot be in the past.");
        } else {
            this.launchTime = launchTime;
        }
    }

    public void launch() {
        try {
            Thread.sleep(sleepTime);
            log.info("The tocket {} was launched.", name);
        } catch (InterruptedException e) {
            log.error("The launch was interrupted. {}.", e.getMessage());
        }
    }

    public void planRocketLaunches(List<RocketLaunch> launches) {
        ExecutorService launchPlanner = Executors.newSingleThreadExecutor();
        long methodStartTime = System.currentTimeMillis();
        List<RocketLaunch> sortedLaunches = launches.stream()
            .sorted(Comparator.comparingLong(RocketLaunch::getLaunchTime))
            .peek(System.out::println)
            .toList();

        for (RocketLaunch launch : sortedLaunches) {
            long waitTime = launch.getLaunchTime() - System.currentTimeMillis();
            try {
                if (waitTime > 0) {
                    Thread.sleep(waitTime);
                }
                launchPlanner.execute(launch::launch);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("The launch was interrupted. {}.", e.getMessage());
            }
        }

        launchPlanner.shutdown();
        try {
            if (!launchPlanner.awaitTermination(5, TimeUnit.SECONDS)) {
                log.error("Time is up. Shutting down the planner now.");
                launchPlanner.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Execution was interrupted. {}.", e.getMessage());
            launchPlanner.shutdownNow();
        }

        log.info("Method execution - {} seconds.", methodStartTime - System.currentTimeMillis());
    }
}
