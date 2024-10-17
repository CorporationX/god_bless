package school.faang.weasley;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Chore implements Runnable {
    private final String chore;

    public Chore(String CHORE) {
        this.chore = CHORE;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " performs the task: " + chore);
            Thread.sleep(1000);
            System.out.println(chore + " completed!");
        } catch (InterruptedException e) {
            log.debug("Task " + chore + " was interrupted.", e);
            e.printStackTrace();
        }
    }
}