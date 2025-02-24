package school.faang.sprint3.task_61155;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record RocketLaunch(String name, long launchTime) {
    private static final int LAUNCH_DELAY_MS = 1000;

    public void launch() {
        try {
            Thread.sleep(LAUNCH_DELAY_MS);
            log.debug("Запущена ракета {}, время запуска {}", name, launchTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Поток прерван", e);
        }
    }
}
