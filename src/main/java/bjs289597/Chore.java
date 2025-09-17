package bjs289597;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Chore implements Runnable {
    private static final int TASK_TIMEOUT_MILLISECONDS = 2000;
    private final String chore;

    @Override
    public void run() {
        try {
            System.out.printf("Thread %s starts the task: %s%n", Thread.currentThread().getName(), chore);
            Thread.sleep(TASK_TIMEOUT_MILLISECONDS);
            System.out.printf("Thread %s finished the task %s%n", Thread.currentThread().getName(), chore);
        } catch (InterruptedException e) {
            System.out.printf("Task %s was terminated!", chore);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
