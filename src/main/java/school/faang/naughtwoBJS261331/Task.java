package school.faang.naughtwoBJS261331;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class Task implements Runnable {
    private String performerName;
    private String task;

    private static final int SLEEP_TIME_MILLIS = 1000;

    @Override
    public void run() {
        try {
            log.info("{} started the task {}", performerName, task);
            Thread.sleep(SLEEP_TIME_MILLIS);
            log.info("{} completed the {}", performerName, task);
        } catch (InterruptedException e) {
            log.debug("Task {} execution interrupted, performer - {}", task, performerName);
            Thread.currentThread().interrupt();
        }
    }
}
