package school.faang.big_bang_theory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
public class Task implements Runnable {
    private static final int TASK_DURATION = 2000;
    private String name;
    private String task;

    @Override
    public void run() {
        log.info("{} started executing the task: {}", name, task);
        try {
            Thread.sleep(TASK_DURATION);
            log.info("{} completed the task: {}", name, task);
        } catch (InterruptedException e) {
            log.info("Task execution was interrupted: {}", task);
            Thread.currentThread().interrupt();
        }
    }

}
