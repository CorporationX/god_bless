package faang.school.godbless.BJS224107;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private final String name;
    private final String task;

    @Override
    public void run() {
        try {
            System.out.println(name + " is starting the task: " + task);
            Thread.sleep(task.length() * 1000L / 2);
            System.out.println(name + " has completed the task: " + task);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}