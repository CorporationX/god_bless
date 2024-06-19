package faang.school.godbless.spacex;

import lombok.AllArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;

@AllArgsConstructor
public class RocketLaunch {
    private final long INITIAL_LAUNCH_TIME = 1000L;
    private String rocketName;
    private LocalDateTime launchTime;

    public void launch() {
        long delay = Duration.between(LocalDateTime.now(), launchTime).toMillis();

        if (delay < 0) {
            throw new RuntimeException("Time is out this rocket is outdated");
        }

        rocketPreparation(delay);
        rocketPreparation(INITIAL_LAUNCH_TIME);

        System.out.println("The rocket " + rocketName + " is gone now");
    }

    private void rocketPreparation(long sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
