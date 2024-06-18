package faang.school.godbless;

import java.util.Random;

public class Task implements Runnable {
    private final String name;
    private final String task;

    public Task(String name, String task) {
        this.name = name;
        this.task = task.toUpperCase();
    }

    @Override
    public void run() {
        System.out.printf("%s is starting task %s\n", name, task);
        try {
            Thread.sleep(new Random().nextInt(10000) + 1000);
            System.out.printf("%s finished the task %s\n", name, task);
        } catch (InterruptedException e) {
            System.out.printf("Execution of task %s by %s is interrupted!\n", task, name);
            throw new RuntimeException(e);
        }
    }
}
