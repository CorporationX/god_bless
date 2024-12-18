package school.faang.sprint3.bjs_48179;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        log.info("Thread {} is working with chore: {}", threadName, chore);
        try {
            Thread.sleep(100);
            log.info("Thread {} completed task", threadName);
        } catch (InterruptedException exception) {
            log.error(exception.getMessage());
        }
    }
}
