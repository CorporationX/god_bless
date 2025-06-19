package school.faang.routine;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@AllArgsConstructor
public class Chore implements Runnable {
    private static final int TIME_SLEEP_MS = 1000;
    private final String chore;

    @Override
    public void run() {
        log.info("Поток {} начал выполнение задачи: {}", Thread.currentThread().getName(), chore);
        try {
            Thread.sleep(TIME_SLEEP_MS);
        } catch (InterruptedException e) {
            log.error("Поток <<{}>> был прерван", Thread.currentThread().getName());
        }
        log.info("Поток {} выполнил задачу: {}", Thread.currentThread().getName(), chore);
    }
}
