package bigbang;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Task implements Runnable {
    private final String name;
    private final String assignment;

    @Override
    public void run() {
        log.info("{} is starting assignment: {}", name, assignment);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            log.error("{}'s assignment was interrupted", name, e);
            Thread.currentThread().interrupt();
            return;
        }
        log.info("{} completed assignment: {}", name, assignment);
    }
}

