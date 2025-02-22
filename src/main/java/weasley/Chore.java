package weasley;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Chore implements Runnable {
    private final String title;
    private static final int TASK_DURATION_MS = 1000;

    @Override
    public void run() {
        try {
            Thread.sleep(TASK_DURATION_MS);
            log.info("Задача {} выполнена потоком {}", title, Thread.currentThread().getName());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Задача {} была прервана.", title);
            throw new RuntimeException("Прерывание выполнения задачи", e);
        }
    }
}
