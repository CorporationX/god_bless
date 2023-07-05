package faang.school.godbless.multithreadingS4.bigBangTheory;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Task implements Runnable {
    private static final Random RANDOM = new Random();
    private static final int COEF_SLEEP = 500;

    private String name;
    private String task;

    @Override
    public void run() {
        System.out.printf("%s started the task %s\n", name, task);
        try {
            Thread.sleep(RANDOM.nextInt(50) * COEF_SLEEP);
            System.out.printf("\t%s finished the task %s\n", name, task);
        } catch (InterruptedException e) {
            System.out.printf("%s has been interrupted\n", Thread.currentThread().getName());
        }
    }
}
