package school.faang.sprint_3.task_48377;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Chore implements Runnable {
    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @SneakyThrows
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " performs the task: " + chore);
            Thread.sleep(100);
            System.out.println(chore + " done!");
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}
