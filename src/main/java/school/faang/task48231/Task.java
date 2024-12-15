package school.faang.task48231;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class Task implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(Task.class);
    private static final int TIME_SLEEP = 5;

    private final String name;
    private final String task;

    @Override
    public void run() {
        System.out.printf("Задача %s начата%n", task);
        try {
            TimeUnit.SECONDS.sleep(TIME_SLEEP);
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage());
            return;
        }

        System.out.printf("%s выполнил задачу: %s%n", name, task);
    }
}
