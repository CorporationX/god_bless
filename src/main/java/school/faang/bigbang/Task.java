package school.faang.bigbang;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(name + " started task: " + task);
        try {
            Thread.sleep(500);
            System.out.println(name + " completed task: " + task);
        } catch (InterruptedException e) {
            System.out.println("Task interrupted: " + task);
            throw new RuntimeException(e);
        }
    }
}
