package space;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@ToString
@RequiredArgsConstructor
@Slf4j
public class RocketLaunch {
    private final String name;
    private final long launchTime;

    public void launch() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Launch of {} was interrupted.", name, e);
            return;
        }
        log.info("Rocket {} is launching!", name);
    }
}
