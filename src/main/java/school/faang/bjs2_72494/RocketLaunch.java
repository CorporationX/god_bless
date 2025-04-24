package school.faang.bjs2_72494;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
public record RocketLaunch(String name, LocalDateTime launchTime) {

    private static int DELAYED_START_TIME = 1000;

    public void launch() {
        try {
            Thread.sleep(DELAYED_START_TIME);
            log.info(String.format("Rocket %s is launched", name));
        } catch (InterruptedException ex) {
            log.error("thread stoppage error");
            Thread.currentThread().interrupt();
        }
    }
}
