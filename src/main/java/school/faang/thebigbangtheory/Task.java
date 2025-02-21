package school.faang.thebigbangtheory;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Task implements Runnable {
    private static final long MAX_TIME_EXECUTED_TASK = 5000;
    private static final long MIN_TIME_EXECUTED_TASK = 1000;

    private String name;
    private String task;

    @Override
    public void run() {
        log.info("{} starting task {}", name, task);
        try {
            Thread.sleep((long) (Math.random() * MAX_TIME_EXECUTED_TASK + MIN_TIME_EXECUTED_TASK));
            log.info("{} finished task {}", name, task);
        } catch (InterruptedException exception) {
            log.error("Task interrupted. Exception: {}\nThread name: {}\nStack trace: {}",
                    exception, Thread.currentThread().getName(), exception.getStackTrace());
            Thread.currentThread().interrupt();
        }
    }
}
