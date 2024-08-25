package faang.school.godbless.bigBangTheory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {

    private final String name;
    private final String task;

    private final long THREAD_SLEEP = 5000L;

    @Override
    public void run() {
        try {
            System.out.println("Task " + task + " for " + name + " started");
            Thread.sleep(THREAD_SLEEP);
            System.out.println("Task " + task + " finished");
        } catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            System.out.println("Error: " + task + " has been interrupted");
        }
    }
}
