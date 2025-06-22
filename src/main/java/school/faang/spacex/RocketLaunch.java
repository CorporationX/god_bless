package school.faang.spacex;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Danil Pudovkin
 * @since 22.06.2025
 */
@Getter
@RequiredArgsConstructor
@Slf4j(topic = "RocketLaunch")
public class RocketLaunch {

    private static final int TIME_BEFORE_LAUCH = 1000;

    private final String name;
    private final long launchTime;

    public void launch() {
        try {
            Thread.sleep(TIME_BEFORE_LAUCH);
            log.info("Ракета {} запускается!", name);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error(e.getMessage());
        }
    }
}
