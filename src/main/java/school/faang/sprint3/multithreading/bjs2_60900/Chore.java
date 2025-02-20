package school.faang.sprint3.multithreading.bjs2_60900;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class Chore implements Runnable {
    private static final int TASK_START_DELAY = 250;
    private static final int TASK_EXECUTION_TIME = 500;
    private String title;

    @SneakyThrows
    @Override
    public void run() {
        try {
            Thread.sleep(TASK_START_DELAY);
            System.out.printf("\nThread '%s' is performing the task '%s'", Thread.currentThread().getName(), title);
            Thread.sleep(TASK_EXECUTION_TIME);
            System.out.printf("\nTask '%s' has been completed", title);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("\nThread {} was interrupted while performing task {}", Thread.currentThread().getName(),
                    title);
        }
    }
}
