package school.faang.bjs2_72667;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Task implements Runnable {
    private static final int SLEEP_DURATION = 1000;

    private final String name;
    private final String task;

    @Override
    public void run() {
        log.info("{} started executing task {}", name, task);
        try {
            Thread.sleep(SLEEP_DURATION);
            log.info("{} finished executing task {}", name, task);
        } catch (InterruptedException e) {
            log.error("Task was interrupted: {}", e.getMessage());
        }
    }
}