package school.faang.chores;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@AllArgsConstructor
@Log4j2
public class Chore implements Runnable {

    private String chore;

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        try {
            System.out.println("Chore " + this.chore + " is doing by " + threadName);
            Thread.sleep(100);
            System.out.println("Thread " + threadName + " completed");
        } catch (InterruptedException e) {
            log.error("Thread" + threadName + "was interrupted", e);
            Thread.currentThread().interrupt();
        }
    }
}
