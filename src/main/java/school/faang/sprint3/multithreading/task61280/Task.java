package school.faang.sprint3.multithreading.task61280;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Task implements Runnable {
    public static final int SLEEP_TIME = 2000;
    private final String name;
    private final String task;

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        log.info("[{}] {} starts performing task '{}'", startTime, name, task);
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            long interruptedTime = System.currentTimeMillis();
            log.warn("\n[{}] thread {} was interrupted while performing task '{}'",
                    interruptedTime,
                    Thread.currentThread().getName(),
                    task);
            Thread.currentThread().interrupt();
        }
        System.out.printf("\n%s has completed his task '%s'", name, task);
    }
}
