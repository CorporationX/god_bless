package school.faang.bjs2_89558;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@AllArgsConstructor
@Getter
@Slf4j
public class Task implements Runnable {
    private static final int MIN_TIME_EXECUTION = 1000;
    private static final int MAX_TIME_EXECUTION = 15000;
    private final String name;
    private final TaskName task;

    @Override
    public void run() {
        try {
            int radomTimeSleep = new Random().nextInt(MIN_TIME_EXECUTION, MAX_TIME_EXECUTION);
            log.info("{} started the task- {}", name, task);
            Thread.sleep(radomTimeSleep);
            log.info("{} completed the task- {}", name, task);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("{} interrupted the task - {}", name, task, e);
        }
    }
}
