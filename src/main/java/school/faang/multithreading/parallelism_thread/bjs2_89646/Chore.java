package school.faang.multithreading.parallelism_thread.bjs2_89646;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public record Chore(String chore) implements Runnable {
    private static final int TIME_DELAY = 1;

    @Override
    public void run() {
        try {
            log.info("Выполняет задачу: {}", chore);
            TimeUnit.SECONDS.sleep(TIME_DELAY);
            log.info("Задача '{}' выполнена!", chore);
        } catch (InterruptedException e) {
            log.error("Задача '{}' была прервана.", chore);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
