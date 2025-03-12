package school.faang.task60814;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record RocketLaunch(String name, long launchTime) {
    private static final int LAUNCH_DELAY = 1000;

    public void launch() {
        try {
            Thread.sleep(LAUNCH_DELAY);
            log.debug("Запущена ракета {}, {} ms", name, launchTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Поток прерван", e);
        }
    }
}