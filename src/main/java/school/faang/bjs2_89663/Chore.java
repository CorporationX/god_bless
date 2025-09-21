package school.faang.bjs2_89663;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public record Chore(String chore) implements Runnable {
    private static final long TASK_DURATION = 1L;

    @Override
    public void run() {
        try {
            log.info("выполняет задачу: {}", chore);
            TimeUnit.SECONDS.sleep(TASK_DURATION);
            log.info("{} выполнена!", chore);
        } catch (InterruptedException e) {
            log.warn("Задача {} была прервана", chore);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}