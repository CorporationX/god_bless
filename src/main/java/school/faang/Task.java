package school.faang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Task implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(Task.class);
    private final String name;
    private final String task;

    @Override
    public void run() {
        try {
            logger.info("{} started {}.", name, task);
            Thread.sleep(2000);
            logger.info("{} finished {}.", name, task);
        } catch (InterruptedException e) {
            logger.error("Task was interrupted,", e);
            throw new RuntimeException(e);
        }

    }

    public Task(String name, String task) {
        validateString(name, "Name");
        validateString(task, "Task");
        this.name = name;
        this.task = task;
    }

    private void validateString(String name, String message) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(message + " can't be null or blank.");
        }
    }
}
