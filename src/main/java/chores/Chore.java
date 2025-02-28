package chores;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.logging.Logger;

@AllArgsConstructor
@Getter
public class Chore implements Runnable {
    private static final Logger logger = Logger.getLogger(Chore.class.getName());
    private static final int TASK_DURATION_MS = 1500;
    private final String title;

    @Override
    public void run() {
        try {
            String threadName = Thread.currentThread().getName();
            logger.info(String.format("%s is starting the chore: %s", threadName, title));
            Thread.sleep(TASK_DURATION_MS);
            logger.info(String.format("%s has finished the chore: %s", threadName, title));
        } catch (InterruptedException e) {
            logger.severe(String.format("Task was interrupted: %s.", title));
            Thread.currentThread().interrupt();
        }
    }
}