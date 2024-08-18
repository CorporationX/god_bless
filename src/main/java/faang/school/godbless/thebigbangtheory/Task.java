package faang.school.godbless.thebigbangtheory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;
    @Override
    public void run() {
        try {
            System.out.printf("%s is doing %s\n", name, task);
            Thread.sleep(3000L);
            System.out.printf("%s finished doing %s\n", name, task);
        } catch (InterruptedException e) {
            System.out.printf("%s was interrupted while doing %s\n", name, task);
            Thread.currentThread().interrupt();
        }
    }
}