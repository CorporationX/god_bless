package school.faang.thebigbangtheory;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@AllArgsConstructor
public class Task implements Runnable {
    private static final int MIN_DELAY = 1000;
    private static final int MAX_DELAY = 5001;
    private String name;
    private String task;

    @Override
    public void run() {
        log.info("{} приступил к выполнению задачи - {}", name, task);
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(MIN_DELAY, MAX_DELAY));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Поток прерван {}", e.getMessage(), e);
        }
        log.info("{} выполнил задачу - {}", name, task);
    }
}
