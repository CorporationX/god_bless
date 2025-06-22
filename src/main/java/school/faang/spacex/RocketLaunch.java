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

    private final String name;
    private final long launchTime;

    public void launch() {
        try {
            Thread.sleep(1000);
            log.info("Ракета {} запускается!", name);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error(e.getMessage());
        }
    }
}
