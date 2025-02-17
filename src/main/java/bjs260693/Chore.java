package bjs260693;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
public class Chore implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(Chore.class);
    private String title;

    @Override
    public void run() {
        try {
            LOGGER.info("Thread {} execute the task {}", Thread.currentThread().getName(), title);
            Thread.sleep(1000);
            LOGGER.info("Thread {} has executed task", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread " + Thread.currentThread().getName() + " has interrupted", e);
        }
    }
}
