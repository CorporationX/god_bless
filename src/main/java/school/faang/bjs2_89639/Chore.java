package school.faang.bjs2_89639;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Chore implements Runnable {
    private static final int THREAD_WORK_MILLIS = 1000;
    private String chore;

    @Override
    public void run() {
        try {
            log.info("{} выполняет задачу: {}", Thread.currentThread().getName(), chore);
            Thread.sleep(THREAD_WORK_MILLIS);
            log.info("Поток {} закончил задачу: {}", Thread.currentThread().getName(), chore);
        } catch (InterruptedException e) {
            log.warn("Задача {} была прервана.", chore);
            Thread.currentThread().interrupt();
        }
    }
}
