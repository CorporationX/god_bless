package school.faang.task_60711;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        try {
            log.info("{} Выполняет задачу по дому: {}", Thread.currentThread().getName(), chore);
            Thread.sleep(ThreadLocalRandom.current().nextInt(1, 11));
            log.info("Задача завершена: {}", chore);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Задача прервана" + chore);
        }
    }
}
