package school.faang.task_48336;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.warn("Thread was interrupted", e);
        }

        System.out.println("Chore '" + chore + "' is done in thread: " + Thread.currentThread().getName());
    }
}
