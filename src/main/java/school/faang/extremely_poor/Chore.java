package school.faang.extremely_poor;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;
    private static final int SLEEP_MILLISECONDS = 2000;

    @Override
    public void run() {
        try {
            Thread.currentThread().getName();
            Thread.sleep(SLEEP_MILLISECONDS);
            log.info("Task {} is done!", chore);
        } catch (InterruptedException e) {
            log.error("Interrupted error {}", e);
            Thread.currentThread().interrupt();
        }
    }
}
