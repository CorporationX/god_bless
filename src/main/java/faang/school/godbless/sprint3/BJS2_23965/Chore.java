package faang.school.godbless.sprint3.BJS2_23965;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        System.out.printf("Task %s started in thread %s%n", chore, Thread.currentThread().getName());
        try {
            Thread.sleep(new Random().nextInt(1, 5) * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Task %s completed%n", chore);
    }
}
