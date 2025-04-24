package school.faang.bjs2_73013;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Chore implements Runnable {
    private final String chore;

    @Override
    public void run() {
        try {
            log.info("{} выполняет задачу {}", Thread.currentThread().getName(), chore);
            Thread.sleep(1000);
            log.info("{} закончил выполнение задачи {}", Thread.currentThread().getName(), chore);
        } catch (InterruptedException e) {
            log.error("Во время выполнения задачи выпало исключение {}", e.getMessage());
        }
    }
}