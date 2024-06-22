package faang.school.godbless.spacex;

import lombok.AllArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;

@AllArgsConstructor
public class RocketLaunch {
    private final long INITIAL_LAUNCH_TIME_IN_MILLIS = 1000L;
    private String rocketName;
    private LocalDateTime launchTime;

    public void launch() {
        long delay = Duration.between(LocalDateTime.now(), launchTime).toMillis();

        if (delay < 0) {
            throw new RuntimeException("Time is out " + rocketName + " is outdated");
        }

        rocketPreparation(delay);
        rocketPreparation(INITIAL_LAUNCH_TIME_IN_MILLIS);

        System.out.println("The rocket " + rocketName + " is gone now");
    }

    private void rocketPreparation(long sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread was interrupted during rocket preparation: " + e.getMessage());
        }
    }
}
