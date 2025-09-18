package school.faang.bjs2_89632;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.TimeUnit;

@Slf4j
public record Chore(String chore) implements Runnable {
    private static final int THREAD_SLEEP_TIME = 200;

    @Override
    public void run() {
        try {
            log.info("Выполняет задачу: {}\n", chore);
            TimeUnit.SECONDS.sleep(THREAD_SLEEP_TIME);
            log.info("Задача {} выполнена\n", chore);
        } catch (InterruptedException e) {
            log.info("Поток %s: Меня прервали в процессе выполнения задачи\n");
            Thread.currentThread().interrupt();
        }
    }
}