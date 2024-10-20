package school.faang.godbless.bjs2_36704;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class Task implements Runnable {
    private static final int TASK_COMPLETION_TIME = 3000;

    private String name;
    private String taskDescription;

    @Override
    public void run() {
        log.info("{} started task {}", name, taskDescription);
        try {
            Thread.sleep(TASK_COMPLETION_TIME);
            log.info("{} completed the task: {}", name, taskDescription);
        } catch (InterruptedException e) {
            log.info("task {} assigned to {} is interrupted when completing", taskDescription, name);
            Thread.currentThread().interrupt();
        }
    }
}
