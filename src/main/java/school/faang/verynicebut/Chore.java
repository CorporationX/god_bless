package school.faang.verynicebut;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Chore implements Runnable {
    private static final Integer TASK_DURATION_MS = 10;
    private final String title;

    @Override
    public void run() {
        try {
            System.out.printf("Выполняем задачу %s в потоке %s\n", title, Thread.currentThread().getName());
            Thread.sleep(TASK_DURATION_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn(e.getMessage());
        }

    }
}
