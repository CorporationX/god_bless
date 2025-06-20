package school.faang.module1.bjs2_81641;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Task implements Runnable {

    private final String name;
    private final String task;
    private static final int TIMEOUT = 3000;

    @Override
    public void run() {
        try {
            log.info("{} начинает задачу {}", name, task);
            Thread.sleep(TIMEOUT);
            log.info("{} завершил задачу {}", name, task);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Поток был прерван во время ожидания", e);
        }
    }
}