package school.faang.bjs2_91200;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Chore implements Runnable {
    private static final int THREAD_SLEEP_COUNT = 1000;
    private final String chore;

    @Override
    public void run() {
        try {
            log.info("{} - Выполняет задачу {}", Thread.currentThread().getName(), chore);
            Thread.sleep(THREAD_SLEEP_COUNT);
            log.info("{} - Выполнил задачу {}", Thread.currentThread().getName(), chore);
        } catch (InterruptedException e) {
            log.info("Thread sleep Exception");
            throw new IllegalStateException(e);
        }
    }
}
