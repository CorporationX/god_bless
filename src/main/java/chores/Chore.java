package chores;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.logging.Logger;

@AllArgsConstructor
@Getter
public class Chore implements Runnable {
    private static final Logger logger = Logger.getLogger(Chore.class.getName());
    private final String title;

    @Override
    public void run() {
        try {
            String threadName = Thread.currentThread().getName();
            logger.info(threadName + " is starting the chore: " + title);
            Thread.sleep(1500);
            logger.info(threadName + " has finished the chore: " + title);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.severe("Task was interrupted: " + title);
        }
    }
}