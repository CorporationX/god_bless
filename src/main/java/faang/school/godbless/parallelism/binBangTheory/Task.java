package faang.school.godbless.parallelism.binBangTheory;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        log.info("The " + task + " execution begins by " + name);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            log.info("Error during execution of " + task + " task.", e);
            return;
        }

        log.info("The " + task + " task was accomplished.");
    }
}
