package school.faang.weasley;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
public class Chore implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(Chore.class);

    private final String title;

    @Override
    public void run() {
        LOGGER.info("Задача {} выполняется", Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            LOGGER.error("The thread has been interrupted");
        }
        LOGGER.info("Задача {} была завершена", Thread.currentThread().getName());
    }
}
