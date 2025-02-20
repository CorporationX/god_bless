package bjs260693;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
public class Chore implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(Chore.class);
    private static final int TASK_DURATION_MS = 1000;
    private String title;

    @Override
    public void run() {
        try {
            LOGGER.info("Thread {} execute the task {}", Thread.currentThread().getName(), title);
            Thread.sleep(TASK_DURATION_MS);
            LOGGER.info("Thread {} has executed task", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            LOGGER.error("Thread {} started, but not completed due to InterruptedException",
                    Thread.currentThread().getName());
            throw new RuntimeException(e);
        }
    }
}
