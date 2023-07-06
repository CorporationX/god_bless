package faang.school.godbless.big_bang_theory;

import lombok.Getter;

@Getter
public class Task implements Runnable {
    private String name;
    private String task;

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println(getName() + " started task: " + getTask());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Task: " + getName() + "was terminated due to: " + e);
            throw new RuntimeException(e);
        }
        System.out.println(getName() + " completed task: " + getTask());
    }
}
