package school.faang.BJS2_60771;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
public class Chore implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(Chore.class);
    private static final String EXECUTED_MESSAGE = "The task '{}' is executed by a thread {}";
    private static final String THREAD_ERROR = "Execution error in the thread {} with task '{}'";
    private static final String COMPLETED_MESSAGE = "The task '{}' is completed";
    public static final int TASK_EXECUTE_TIME = 5000;
    private final String name;

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        logger.info(EXECUTED_MESSAGE, name, thread.getName());
        try {
            Thread.sleep(TASK_EXECUTE_TIME);
            logger.info(COMPLETED_MESSAGE, name);

        } catch (InterruptedException e) {
            logger.error(THREAD_ERROR, thread, name);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
