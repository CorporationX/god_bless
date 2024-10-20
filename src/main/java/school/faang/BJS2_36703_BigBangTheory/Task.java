package school.faang.BJS2_36703_BigBangTheory;

import lombok.AllArgsConstructor;

import java.util.concurrent.ThreadLocalRandom;

@AllArgsConstructor
public class Task implements Runnable{
    private static final int MILLISECONDS_IN_SECOND = 1000;
    private static final int MIN_SLEEP_TIME_SECONDS = 1;
    private static final int MAX_SLEEP_TIME_SECONDS = 5;

    private String name;
    private String task;

    @Override
    public void run() {
        System.out.printf("Person %s started the task: %s\n", name, task);
        int sleepTime = ThreadLocalRandom.current().nextInt(MIN_SLEEP_TIME_SECONDS, MAX_SLEEP_TIME_SECONDS + 1) * MILLISECONDS_IN_SECOND;
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            throw new IllegalStateException(
                    String.format("The thread %s was interrupted while its execution!", Thread.currentThread().getName()),
                    e
            );
        }
        System.out.printf("Person %s finished the task: %s\n", name, task);
    }
}
