package school.faang.sprint3.multithreading.task61280;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Task implements Runnable {
    private final String name;
    private final String task;

    @Override
    public void run() {
        System.out.printf("\n%s starts performing task %s", name, task);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.warn("\nThe thread {} was interrupted while performing task '{}'",
                    Thread.currentThread().getName(),
                    task);
            Thread.currentThread().interrupt();
            return;
        }
        System.out.printf("\n%s has completed his task '%s'", name, task);
    }
}
