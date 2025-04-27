package bjs2_72969;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    public void run() {
        try {
            log.info("Task {} : {} started", Thread.currentThread().getName(), chore);
            Thread.sleep(1000);
            log.info("Task " + chore + " finished");
        } catch (InterruptedException e) {
            log.error("Task " + chore + " interrupted");
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Task " + chore +  "was interrupted while sleeping", e);
        }
    }
}
