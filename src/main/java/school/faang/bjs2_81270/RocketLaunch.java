package school.faang.bjs2_81270;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record RocketLaunch(String name, long launchTime) {
    public void launch() {
        try {
            Thread.sleep(1000);
            log.info("Стартует ракета {}", name);

        } catch (InterruptedException e) {
            log.error("Поток был прерван");
            Thread.currentThread().interrupt();
        }
    }
}
