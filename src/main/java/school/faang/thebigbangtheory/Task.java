package school.faang.thebigbangtheory;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        log.info("{} starting task {}", name, task);
        try {
            Thread.sleep(3000);
            log.info("{} finished task {}", name, task);
        } catch (InterruptedException exception) {
            log.error("Task interrupted. {}\n{}", exception, Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
    }
}
