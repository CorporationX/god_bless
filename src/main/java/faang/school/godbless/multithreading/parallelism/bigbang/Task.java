package faang.school.godbless.multithreading.parallelism.bigbang;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {

    private String name;
    private String description;

    @Override
    public void run() {
        System.out.println("Task " + name + " started: " + description);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Task " + name + " interrupted");
        }
        System.out.println("Task " + name + " finished: " + description);
    }
}
