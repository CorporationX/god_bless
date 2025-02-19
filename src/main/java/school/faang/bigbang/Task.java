package school.faang.bigbang;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.logging.Level;
import java.util.logging.Logger;

@AllArgsConstructor
@Getter
public class Task implements Runnable {
    private String name;
    private String task;
    private static final Logger LOGGER = Logger.getLogger(Task.class.getName());

    @Override
    public void run() {
        LOGGER.setLevel(Level.INFO);
        LOGGER.info(task + " is started by " + name);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            LOGGER.info("The task was interrupted");
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        LOGGER.info("The task " + getTask() + " was done by " + getName());
    }
}
