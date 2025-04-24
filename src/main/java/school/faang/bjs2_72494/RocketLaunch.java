package school.faang.bjs2_72494;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

import static java.lang.Thread.currentThread;

@Slf4j
public record RocketLaunch(String name, LocalDateTime launchTime) {

    private static final int DELAYED_START_TIME = 1000;

    public void launch() {
        try {
            Thread.sleep(DELAYED_START_TIME);
            log.info("Rocket {} is launched", name);
        } catch (InterruptedException ex) {
            log.error("thread stoppage error");
            currentThread().interrupt();
        }
    }
}
