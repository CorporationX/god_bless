package school.faang.bjs2_72494;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record RocketLaunch(String name, int launchTime) {
    private void launch() {
        try {
            Thread.sleep(1000);
            log.info(String.format("Rocket %s is launched", name));
        } catch (InterruptedException ex) {
            log.error("thread stoppage error");
        }
    }
}
