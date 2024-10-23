package school.faang.java.thread1.familyweasley;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Chore implements Runnable {
    private int numberInQueue;
    private String chore;
    private int workingTime;

    @Override
    public void run() {
        System.out.printf("\nStart ====>>> Number: %d === A task name: %s. === Working time: %d === Current thread name: %s", numberInQueue, chore, workingTime, Thread.currentThread().getName());
        try {
            Thread.sleep(workingTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("\nEnd ====>>> Number: %d === A task name: %s. === Working time: %d === Current thread name: %s", numberInQueue, chore, workingTime, Thread.currentThread().getName());
    }
}
