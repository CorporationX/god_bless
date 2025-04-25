package school.faang.extremely_poor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Chore implements Runnable {
    public static final int SLEEP_MILLIS = 2000;
    private final String chore;

    @Override
    public void run() {
        log.info("{} выполняет задачу {}", Thread.currentThread().getName(), chore);
        try {
            Thread.sleep(SLEEP_MILLIS);
        } catch (InterruptedException e) {
            log.error("Действие текущего потока прервано.");
        }
    }
}
