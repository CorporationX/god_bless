package school.faang.bjs2_89611;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Chore implements Runnable {
    private static final int THREAD_SLEEP = 1000;
    private String chore;

    @Override
    public void run() {
        log.info("Поток {} выполняет задачу: {}", Thread.currentThread().getName(), chore);
        try {
            Thread.sleep(THREAD_SLEEP);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.info("Задача была прервана");
        }
        log.info("Поток {} завершил задачу: {}", Thread.currentThread().getName(), chore);
    }
}