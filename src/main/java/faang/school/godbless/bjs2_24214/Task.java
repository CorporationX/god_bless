package faang.school.godbless.bjs2_24214;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Task implements Runnable {
    private static final int MAX_RANDOM_VALUE = 5;

    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(task + " is started by " + name);
        try {
            Thread.sleep(1000 * (new Random().nextInt(MAX_RANDOM_VALUE) + 1));
        } catch (InterruptedException e) {
            System.out.println(task + " was interrupted");
        }
        System.out.println(name + " completed the task: " + task);
    }
}
