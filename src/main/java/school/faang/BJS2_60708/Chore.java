package school.faang.BJS2_60708;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
public class Chore implements Runnable {
    private final String chore;
    private final Logger logger = LoggerFactory.getLogger(Chore.class);
    private final int taskTime = 100;

    @Override
    public void run() {
        System.out.printf("Имя потока: %s выполняет задачу: %s%n",
                Thread.currentThread().getName(), chore);
        try {
            Thread.sleep(taskTime);
        } catch (InterruptedException e) {
            logger.error("Задача {} не завершина", chore, e);
            Thread.currentThread().interrupt();
        }
    }
}
