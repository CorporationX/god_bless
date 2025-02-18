package school.faang.thebigbangtheory;

import lombok.AllArgsConstructor;

import java.util.logging.Logger;

@AllArgsConstructor
public class Task implements Runnable {
    private static final Logger LOGGER = Logger.getLogger(Task.class.getName());
    private final String name;
    private final Goal task;

    @Override
    public void run() {
        LOGGER.info(name + " начал выполнять задачу:" + task);
        int taskTimer = 2000;
        try {
            Thread.sleep(taskTimer);
        } catch (InterruptedException e) {
            LOGGER.severe(e.getMessage());
            Thread.currentThread().interrupt();
        }
        LOGGER.info(name + " закончил выполнение задачи" + task);
    }
}
