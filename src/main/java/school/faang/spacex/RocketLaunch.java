package school.faang.spacex;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class RocketLaunch {

    private static final long MOCK_LAUNCH_PROCESS_TIME = 1000;

    private final String name;
    private final long launchTime;

    public void launch() {
        long delay = launchTime - System.currentTimeMillis();
        try {
            if (launchTime - System.currentTimeMillis() > 0) {
                log.info("Rocket {} await launching for {} ms", name, delay);
                Thread.sleep(delay);
            }
            log.info("Rocket {} start launching...", name);
            Thread.sleep(MOCK_LAUNCH_PROCESS_TIME);
        } catch (InterruptedException e) {
            log.info("Rocket {} launch interrupted. Planning stopped.", name);
            Thread.currentThread().interrupt();
        }
        log.info("Rocket {} launched", name);
    }
}
