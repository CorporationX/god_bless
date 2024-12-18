package school.faang.sprint_3.task_bjs248550;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Chore implements Runnable {
    private final String chore;

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        log.info("Thread {} is working on {}", threadName, chore);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.warn("Thread {} was interrupted", threadName);
            Thread.currentThread().interrupt();
        }
    }
}
