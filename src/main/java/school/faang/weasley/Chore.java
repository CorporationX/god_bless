package school.faang.weasley;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
public class Chore implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(Chore.class);
    private static final int TASK_EXECUTION_TIME = 5000;

    private final String title;

    @Override
    public void run() {
        LOGGER.info("Задача {} выполняется", title);
        try {
            Thread.sleep(TASK_EXECUTION_TIME);
        } catch (InterruptedException e) {
            LOGGER.error("Поток был прерван: {}", e.getMessage());
            Thread.currentThread().interrupt();
        }
        LOGGER.info("Задача {} была завершена", title);
    }
}
