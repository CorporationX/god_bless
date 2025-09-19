package school.faang.bjs2_89564;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Task implements Runnable {
    private final String name;
    private final String task;

    @Override
    public void run() {
        log.info("{} начинает выполнение задачи: {}", name, task);
        try {
            Thread.sleep(2000);
            log.info("{} завершил выполнение задачи: {}", name, task);
        } catch (InterruptedException e) {
            log.info("{} был прерван при выполнении задачи: {}", name, task);
            Thread.currentThread().interrupt();
        }
    }
}