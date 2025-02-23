package school.faang.task_60711;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;
    private static final int START_TIME = 1000;
    private static final int FINAL_TIME = 10000;

    @Override
    public void run() {
        try {
            log.info("{} Выполняет задачу по дому: {}", Thread.currentThread().getName(), chore);
            Thread.sleep(ThreadLocalRandom.current().nextInt(START_TIME, FINAL_TIME));
            log.info("Задача завершена: {}", chore);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Задача прервана" + chore);
        }
    }
}
