package faang.school.godbless.TheBigBangTheory;

import java.util.Random;

public class Task implements Runnable{
    private String name;
    private String task;

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println(this.name + " started " + task);
        try {
            Thread.sleep(new Random().nextInt(5));
        } catch (InterruptedException e) {
            throw new RuntimeException("Task interrupted");
        }
    }
}
