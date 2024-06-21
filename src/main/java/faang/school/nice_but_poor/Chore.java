package faang.school.nice_but_poor;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Chore implements Runnable {
    private String taskName;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is processing " + taskName + "task");
        try {
            Thread.sleep(new Random().nextInt(1, 6) * 1000L);
            System.out.println(Thread.currentThread().getName() + " processed " + taskName);
        } catch (InterruptedException e) {
            throw new RuntimeException("Could not process task " + taskName + e.getMessage());
        }
    }
}
