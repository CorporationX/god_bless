package school.faang.task_48810;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Chore implements Runnable {

    private static final int DELAY = 2000;
    private String chore;

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + ": " + chore);
            Thread.sleep(DELAY);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}
