package Multithreading.bc2319;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        try {
            System.out.println("Thread: " + Thread.currentThread().getName() + " performs task: " + chore);
            Thread.sleep(3000);
            System.out.println("Task: " + chore + " completed");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
