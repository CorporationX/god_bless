package faang.school.godbless.thebigbangtheory2852;

import lombok.Getter;

import java.sql.SQLOutput;

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
        String name = this.getName();
        String task = this.getTask();
        System.out.printf("%s is doing a very important job - %s%n", name, task);
        try {
            Thread.sleep(7000);
        } catch (InterruptedException exception) {
            System.out.printf("Somebody interrupted %s. He can't continue now:(%n", name);
            return;
        }
    }
}
