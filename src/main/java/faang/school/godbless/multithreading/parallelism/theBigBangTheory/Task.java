package faang.school.godbless.multithreading.parallelism.theBigBangTheory;

import lombok.Data;

import java.util.Random;

@Data
public class Task implements Runnable {
    private final String name;
    private final String task;

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println(name + " started task: " + task );
        try {
            Thread.sleep(new Random().nextInt(100, 5000));
        } catch (InterruptedException e) {
            System.out.println("Task: " + task + " was interrupted");
        }
    }
}
