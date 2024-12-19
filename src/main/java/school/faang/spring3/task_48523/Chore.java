package school.faang.spring3.task_48523;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Getter
@Slf4j
public class Chore implements Runnable {

    private static final int SLEEP_TIME = 1000;
    private String chore;

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()
                    + " начал выполнять задачу " + chore);
            Thread.sleep(SLEEP_TIME);
            System.out.println(Thread.currentThread().getName()
                    + " закончил выполнять задачу " + chore);
        } catch (InterruptedException e) {
            log.warn("Задача была прервана");
        }

    }
}
