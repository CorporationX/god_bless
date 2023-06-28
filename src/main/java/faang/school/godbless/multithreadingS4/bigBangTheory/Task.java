package faang.school.godbless.multithreadingS4.bigBangTheory;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Task implements Runnable {
    private static final Random RANDOM = new Random();
    private static final int COEF_SLEEP = 100;
    
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.printf("%s started the task %s\n", name, task);
        try {
            Thread.sleep(RANDOM.nextInt(50) * COEF_SLEEP);
        } catch (InterruptedException e) {
            System.out.printf("%s has been interrupted\n", Thread.currentThread().getName());
            e.getStackTrace();
        }
        System.out.printf("\t%s finished the task %s\n", name, task);
    }
}
