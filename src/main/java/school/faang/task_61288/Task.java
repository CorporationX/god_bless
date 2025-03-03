package school.faang.task_61288;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Task implements Runnable {
    private final String name;
    private final String task;

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        log.info("The task {} is started by {}!", task, name);
        try {
            Thread.sleep(3000);
            log.info("The task {} is done by {}!", task, name);
        } catch (InterruptedException e) {
            log.info("The task {} was interrupted: {}", task, e.getMessage());
        }
    }
}
