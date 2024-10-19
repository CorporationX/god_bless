package school.faang.Mnogopotochka.ParallelismThread.BJS2_36683;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.logging.Level;
import java.util.logging.Logger;

@Data
@AllArgsConstructor
public class Task implements Runnable {
    private static final Logger logger = Logger.getLogger(Task.class.getName());

    private String name;
    private String task;

    @Override
    public void run() {
        logger.info(name + " performs: " + task);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            logger.log(Level.WARNING, "Thread interrupted: " + Thread.currentThread(), e);
            Thread.currentThread().interrupt();
        }
        logger.info(name + " completed: " + task);
    }
}
