package school.faang.thebigbangtheory;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Task implements Runnable {
    private static final int TASK_TIMER = 2000;
    private final String name;
    private final Goal goal;

    @Override
    public void run() {
        log.info("{} начал выполнять задачу: {}", name, goal);
        try {
            Thread.sleep(TASK_TIMER);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
            Thread.currentThread().interrupt();
        }
        log.info("{} закончил выполнение задачи{}", name, goal);
    }
}
