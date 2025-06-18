package school.faang.routine;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Chore implements Runnable {
    private final String chore;

    @Override
    public void run() {
        log.info("Поток {} начал выполнение задачи: {}", Thread.currentThread().getName(), chore);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("Поток <<{}>> был прерван", Thread.currentThread().getName());
        }
        log.info("Поток {} выполнил задачу: {}", Thread.currentThread().getName(), chore);
    }
}
