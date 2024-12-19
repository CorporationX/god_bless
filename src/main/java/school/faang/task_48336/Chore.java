package school.faang.task_48336;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;
    private static final int SLEEP_TIME = 1000;

    public void run() {
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            log.warn("Thread was interrupted", e);
        }

        System.out.println("Chore '" + chore + "' is done in thread: " + Thread.currentThread().getName());
    }
}
