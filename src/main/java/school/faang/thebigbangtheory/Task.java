package school.faang.thebigbangtheory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        try {
            System.out.println(name + " starts working on: " + task);

            Thread.sleep(2000);

            System.out.println(name + " completed: " + task);
        } catch (InterruptedException e) {
            System.out.println(name + " was interrupted while working on: " + task);
            Thread.currentThread().interrupt();
        }
    }
}

