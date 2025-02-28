package bigbangtheory;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class Task implements Runnable {
    private final String name;
    private final String task;
    private final Random random = new Random();

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        try {
            String threadName = Thread.currentThread().getName();
            log.info("{}: {} is starting by {}", threadName, task, name);
            Thread.sleep(1000 + random.nextInt(2000));
            log.info("{}: {} has finished by {}", threadName, task, name);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("{} was interrupted during the task: {}", name, task);
        }
    }
}