package school.faang.java.thread1.familyweasley;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Chore implements Runnable{

    private String chore;
    private int workingTime;

    @Override
    public void run() {
        System.out.printf("\nA task name: %s. Current thread name: %s", chore, Thread.currentThread().getName());
        try {
            Thread.sleep(workingTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
