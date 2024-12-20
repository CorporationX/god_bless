package school.faang.sprint3.bjs_48179;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Chore implements Runnable {
    private static final int DELAY = 100;
    private String chore;

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        log.info("Thread {} is working with chore: {}", threadName, chore);
        try {
            Thread.sleep(DELAY);
            log.info("Thread {} completed task", threadName);
        } catch (InterruptedException exception) {
            log.error(exception.getMessage());
        }
    }
}
