package school.faang.bjs2_73005;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record RocketLaunch(String name, long launchTime) {
    private static final int SLEEP_DURATION = 1000;

    public void launch() {
        try {
            log.info("Launching of rocket {} started", name);
            Thread.sleep(SLEEP_DURATION);
            log.info("Launching of rocket {} finished", name);
        } catch (InterruptedException e) {
            log.error("Interrupted exception with message {} was thrown", e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}