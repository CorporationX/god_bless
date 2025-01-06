package school.faang.sprint_3.task_48282;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record Task(Person person, String task) implements Runnable {
    private static final long TASK_EXECUTION_TIME = 2000L;

    @Override
    public void run() {
        try {
            log.info("{} started the task: {}", person.name(), task());
            Thread.sleep(TASK_EXECUTION_TIME);
            log.info("{} completed the task.", person.name());
        } catch (InterruptedException e) {
            log.error("Task execution interrupted, error message: ", e);
            Thread.currentThread().interrupt();
        }
    }
}
