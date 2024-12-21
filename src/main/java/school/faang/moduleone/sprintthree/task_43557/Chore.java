package school.faang.moduleone.sprintthree.task_43557;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        try {
            log.info("{} выполняет задачу: {}", Thread.currentThread().getName(), chore);
            Thread.sleep(1000);
            log.info("Задача {} выполнена!", chore);
        } catch (InterruptedException e) {
            log.error("Задача {} была прервана", chore);
        }
    }
}
