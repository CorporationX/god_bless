package school.faang.bjs2_72494;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
public record RocketLaunch(String name, LocalDateTime launchTime) {
    public void launch() {
        try {
            Thread.sleep(1000);
            log.info(String.format("Rocket %s is launched", name));
        } catch (InterruptedException ex) {
            log.error("thread stoppage error");
            Thread.currentThread().interrupt();
        }
    }
}
