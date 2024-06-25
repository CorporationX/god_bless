package faang.school.godbless;

import java.util.Random;

public class Task implements Runnable {
    private final String name;
    private final String task;
    private static final int THREAD_MAX_SLEEP = 10000;
    private static final int THREAD_MIN_SLEEP = 1000;

    public Task(String name, String task) {
        this.name = name;
        this.task = task.toUpperCase();
    }

    @Override
    public void run() {
        System.out.printf("%s is starting task %s\n", name, task);
        try {
            Thread.sleep(new Random().nextInt(THREAD_MAX_SLEEP) + THREAD_MIN_SLEEP);
            System.out.printf("%s finished the task %s\n", name, task);
        } catch (InterruptedException e) {
            throw new RuntimeException(String.format("Execution of task %s by %s is interrupted!\n", task, name), e);
        }
    }
}
