package faang.school.godbless.multithreading.parallelism.theywere;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {

    private String task;

    @Override
    public void run() {
        System.out.println("Running chore: " + task + " on thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Chore: " + task + " completed on thread: " + Thread.currentThread().getName());
    }
}
