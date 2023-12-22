package faang.school.godbless.BJS2_1093;

import lombok.Data;

@Data
public class Task implements Runnable {
    private String name;
    private String task;

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println(this.name + " started the task " + task);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(this.name + " interrupted the task " + task);
        }
        System.out.println(this.name + " finished the task " + task);
    }
}