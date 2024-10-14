package school.faang.nicebutpoor;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        try {
            System.out.println("Thread: " + threadName + " - Task started: " + chore);
            Thread.sleep(5000);
            System.out.println("Thread: " + threadName + " - Task finished: " + chore);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + threadName + " - Task NOT finished: " + chore);
            throw new RuntimeException(e);
        }

    }
}
