package school.faang.bjs2_61007;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class Chore implements Runnable {
    private final String title;
    private static final int TASK_DURATION_MS = 1000;

    @Override
    public void run() {
        try {
            log.info(Thread.currentThread().getName() + " выполняет задачу: " + title);
            Thread.sleep(TASK_DURATION_MS);
            log.info("Задача " + title + " выполнена!");

        } catch (InterruptedException e) {
            log.info("Задача " + title + " была прервана.");
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }


}
