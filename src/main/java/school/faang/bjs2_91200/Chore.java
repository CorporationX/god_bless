package school.faang.bjs2_91200;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Chore implements Runnable {
    private final String chore;

    @Override
    public void run() {
        try {
            log.info("{} - Выполняет задачу {}", Thread.currentThread().getName(), chore);
            Thread.sleep(1000);
            log.info("{} - Выполнил задачу {}", Thread.currentThread().getName(), chore);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
