package school.faang.poor;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.logging.Level;
import java.util.logging.Logger;

@AllArgsConstructor
@Getter
public class Chore implements Runnable{
    private static final Logger logger = Logger.getLogger(Chore.class.getName());
    private final String choreName;

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        try {
            System.out.println("The thread is running: " + threadName + " for chore: " + choreName);
            Thread.sleep(100);
            System.out.println("The thread is done: " + threadName);
        } catch (InterruptedException e) {
            logger.log(Level.SEVERE, "Something bad had happened with thread: " + threadName, e);
        }
    }
}
