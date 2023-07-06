package big_bang_theory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record Task(String name, String task) implements Runnable {
    @Override
    public void run() {
        log.info(name() + " starts implement " + task());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException("implementation of the task was interrupted", e.getCause());
        }
        log.info(name() + " finished implementation of the " + task());
    }
}
