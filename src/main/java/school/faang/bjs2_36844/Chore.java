package school.faang.bjs2_36844;

import lombok.AllArgsConstructor;

import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        System.out.println("Task: " + chore + " " + Thread.currentThread().getName() + " started execution");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new IllegalStateException("Thread was interrupted unexpectedly during sleep");
        }
        System.out.println("Task: " + chore + " " + Thread.currentThread().getName() + " completed");
    }
}
