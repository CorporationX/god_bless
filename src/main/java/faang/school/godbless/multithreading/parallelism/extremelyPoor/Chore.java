package faang.school.godbless.multithreading.parallelism.extremelyPoor;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String choreDescription;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            System.out.println(choreDescription + " - began.");
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        System.out.println(choreDescription + " - finished.");
    }
}
