package school.faang.BJS2_36294_SpaceX;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public class RocketLaunch {
    private static final int BEFORE_LAUNCH_TIME = 1_000;

    private String name;
    private int launchTime;

    public void launch() {
        try {
            Thread.sleep(BEFORE_LAUNCH_TIME);
        } catch (InterruptedException e) {
            log.error(
                    "Thread {} was interrupted while waiting for the launch of Rocket {}",
                    Thread.currentThread().getName(), name, e
            );
        }
        log.info("The launch of Rocket {} has begun...", name);
    }
}
