package faang.school.godbless.spring_4.the_big_bang_theory;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
    private final String name;
    private final String task;

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    public String getName() {
        return name;
    }

    public String getTask() {
        return task;
    }

    @Override
    public void run() {
        System.out.println("I started to complete the task: " + name);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            System.out.println("task aborted !");
        }
    }
}
