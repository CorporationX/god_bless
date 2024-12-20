package school.faang.spring3.task_48302;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@AllArgsConstructor
@Slf4j
public class Task implements Runnable {
    private static final int MIN_TIME = 1000;
    private static final int MAX_TIME = 5000;

    private String name;
    private String task;

    @Override
    public void run() {
        try {
            log.info("{} started task {}", name, task);
            Thread.sleep(new Random().nextInt(MIN_TIME, MAX_TIME));
            log.info("{} finished task {}", name, task);
        } catch (InterruptedException e) {
            log.error("Task was interrupted");
        }
    }
}
