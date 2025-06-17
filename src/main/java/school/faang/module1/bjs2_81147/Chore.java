package school.faang.module1.bjs2_81147;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Chore implements Runnable {

    private final String chore;
    private static final int TIMEOUT = 3000;

    @Override
    public void run() {
        log.info("Поток {} начинает задачу {}", Thread.currentThread().getName(), chore);
        try {
            Thread.sleep(TIMEOUT);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Поток {} был прерван", Thread.currentThread().getName());
        }
        log.info("Поток {} завершил задачу {}", Thread.currentThread().getName(), chore);
    }
}