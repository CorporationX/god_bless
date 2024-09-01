package faang.school.godbless.big.bang.theory;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Task implements Runnable {
    public static final int TIME_FOR_THINKING = 2;
    public static final int TIME_FOR_WORKING = 3;

    private final String name;
    private final String task;

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        System.out.printf("%s has started his task \"%s\"\n", name, task);
        System.out.printf("%s is thinking\n", name);
        try {
            TimeUnit.SECONDS.sleep(TIME_FOR_THINKING);
            System.out.printf("%s is doing his task \"%s\"\n", name, task);
            TimeUnit.SECONDS.sleep(TIME_FOR_WORKING);
            System.out.printf("%s did his task \"%s\"\n", name, task);
        } catch (InterruptedException exception) {
            log.error(String.format("Thread was interrupted while %s did his task \"%s\"", name, task), exception);
            Thread.currentThread().interrupt();
        }
    }
}
