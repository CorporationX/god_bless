package big.bang.theory;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;
    private static final int MILLIS_FOR_SLEEP = 2000;

    @Override
    public void run() {
        log.info("{} начинает выполнение задачи {}...", name, task);
        try {
            Thread.sleep(MILLIS_FOR_SLEEP);
        } catch (InterruptedException e) {
            log.error("Thread was interrupted! {}", e.getMessage());
            Thread.currentThread().interrupt();
        }
        log.info("{} закончил выполнение задачи {}.", name, task);
    }
}
