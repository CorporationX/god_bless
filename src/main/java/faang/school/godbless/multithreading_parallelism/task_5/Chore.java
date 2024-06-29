package faang.school.godbless.multithreading_parallelism.task_5;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private final String chore;

    private final static int CHORE_TIME_COMPLETION = 5000;

    @Override
    public void run() {
        System.out.println(chore + " Started in thread " + Thread.currentThread().getName());
        try {
            Thread.sleep(CHORE_TIME_COMPLETION);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
