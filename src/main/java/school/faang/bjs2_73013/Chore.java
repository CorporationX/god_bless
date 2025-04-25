package school.faang.bjs2_73013;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Chore implements Runnable {
    private static final int SLEEP_DURATION = 1000;

    private final String chore;

    @Override
    public void run() {
        try {
            log.info("{} выполняет задачу {}", Thread.currentThread().getName(), chore);
            Thread.sleep(SLEEP_DURATION);
            log.info("{} закончил выполнение задачи {}", Thread.currentThread().getName(), chore);
        } catch (InterruptedException e) {
            log.error("Во время выполнения задачи выпало исключение {}", e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}