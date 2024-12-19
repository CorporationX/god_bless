package school.faang.sprint_3.task_48377;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Chore implements Runnable {
    private static final int TASK_EXECUTION_TIME = 1000;
    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @SneakyThrows
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " performs the task: " + chore);
            Thread.sleep(TASK_EXECUTION_TIME);
            System.out.println(chore + " done!");
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}
