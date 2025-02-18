package bigbangtheory;

import java.util.Random;
import java.util.logging.Logger;

public class Task implements Runnable {
    private static final Logger logger = Logger.getLogger(Task.class.getName());
    private final String name;
    private final String task;
    private final Random random = new Random();

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        try {
            String threadName = Thread.currentThread().getName();
            logger.info(String.format("%s: %s is starting by %s", threadName, task, name));
            Thread.sleep(1000 + random.nextInt(2000));
            logger.info(String.format("%s: %s has finished by %s", threadName, task, name));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.severe(String.format("%s was interrupted during the task: %s", name, task));
        }
    }
}