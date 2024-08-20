package faang.school.godbless.sprint3.BJS2_24016;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        try {
            System.out.printf("Task %s started%n", task);
            Thread.sleep(new Random().nextInt(1, 5) * 1000L);
            System.out.printf("Task %s is done!%n", task);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
