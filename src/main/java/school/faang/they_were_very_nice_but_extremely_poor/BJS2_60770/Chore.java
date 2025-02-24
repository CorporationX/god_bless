package school.faang.they_were_very_nice_but_extremely_poor.BJS2_60770;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
public class Chore implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(Chore.class);

    private static final int TASK_EXECUTION_TIME = 3000;

    private final String title;

    @Override
    public void run() {
        LOGGER.info("Потоком {} выполняется: {}", Thread.currentThread().getName(), title);
        try {
            Thread.sleep(TASK_EXECUTION_TIME);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LOGGER.error("Поток был прерван. Причина: {}", e.getMessage());
        }
    }
}
