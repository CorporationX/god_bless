package school.faang.task_48483;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@AllArgsConstructor
@Slf4j
public class Chore implements Runnable {

    private static final int SLEEP_TIME = 1000;


    private String chore;

    @Override
    public void run() {
        try {
            System.out.printf("Поток: %s\n Выполняет задачу: %s ", Thread.currentThread().getName(), chore);
            Thread.sleep(SLEEP_TIME);
            System.out.println(chore + " - задача выполнена!");
        } catch (InterruptedException e) {
            log.info("Ошибка при выполнении задачи: " + e.getMessage());
        }
    }
}
