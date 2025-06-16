package school.faang.bjs2_81136;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Chore implements Runnable {
    private final String choreName;

    @Override
    public void run() {
        try {
            log.info("{} выполняет задачу: {}", Thread.currentThread().getName(), choreName);
            Thread.sleep(5000);
            log.info("Задача {} выполнена", choreName);
        } catch (InterruptedException e) {
            log.error("Interrupted while doing the chore {}", Thread.currentThread().getName());
            Thread.currentThread().interrupt();
            log.error("Stack trace: ", e);
        }
    }
}
