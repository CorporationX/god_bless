package faang.school.godbless.TheBigBangTheory;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(this.name + " started " + task);
        try {
            Thread.sleep(new Random().nextInt(5));
        } catch (InterruptedException e) {
            System.out.println("Task interrupted");
        }
        System.out.println(this.name + "finished" + task);
    }
}
