package bjs289597;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Chore implements Runnable {
    private final String chore;

    @Override
    public void run() {
        try {
            System.out.println("Thread " + Thread.currentThread().getName() + " starts the task: " + chore);
            Thread.sleep(2000);
            System.out.println("Thread " + Thread.currentThread().getName() + " starts the task" + chore);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
