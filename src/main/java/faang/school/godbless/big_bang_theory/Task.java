package faang.school.godbless.big_bang_theory;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Task implements Runnable {

    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(name + " have started to work on \"" + task + "\" task...");
        try {
            Thread.sleep(new Random().nextInt(15_000));
            System.out.println(name + " has completed his task!");
        } catch (InterruptedException e) {
            throw new RuntimeException("Task was interrupted");
        }
    }
}
