package school.faang.task_48237;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Chore implements Runnable {
    private final ChoreType chore;

    public Chore(@NonNull ChoreType chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        try {
            log.info("{} выполняет задачу: {}",
                    Thread.currentThread().getName(), chore);
            Thread.sleep(1000);
            log.info("Задача {} выполнена!", chore);
        } catch (InterruptedException e) {
            log.error("Задача {} была прервана.", chore);
        }
    }

}
