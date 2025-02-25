package school.faang.bigbang;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        log.info("{} is started by {}", task, name);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            log.error("The task was interrupted");
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        log.info("The task {} was done by {}", task, name);
    }
}
