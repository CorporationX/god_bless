package faang.school.godbless.task.multithreading.space.x;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@RequiredArgsConstructor
public class RocketLauncher {
    private static final int DELAY_TIME = 1000;

    private final String name;
    private final long timeOfStart;

    public void launch() {
        threadSleep();
        log.info("{} start", name);

    }

    private static void threadSleep() {
        try {
            Thread.sleep(DELAY_TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
