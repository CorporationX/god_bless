package school.faang.nice_but_poor;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@ToString
public class Chore implements Runnable {
    private final String chore;

    @Override
    public void run() {
        System.out.printf("Задачу %s выполняет поток %s%n", chore, Thread.currentThread().getName());
        try {
            log.debug("starting to sleep...");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            log.error("Thread interrupted", e);
            Thread.currentThread().interrupt();
        }
    }
}
