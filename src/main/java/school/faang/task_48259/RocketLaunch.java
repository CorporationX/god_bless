package school.faang.task_48259;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
@RequiredArgsConstructor
public class RocketLaunch {
    private static final int DELAY_BEFORE_ROCKET_LAUNCH = 3000;

    private final String name;
    private final long launchTime;

    public void launch() {
        try {
            Thread.sleep(DELAY_BEFORE_ROCKET_LAUNCH);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        log.info("A rocket called {} is launched", name);
    }
}
