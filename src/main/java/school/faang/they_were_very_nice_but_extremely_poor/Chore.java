package school.faang.they_were_very_nice_but_extremely_poor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
@RequiredArgsConstructor
public class Chore implements Runnable {
    private final String chore;
    private final Random random = new Random();

    @Override
    public void run() {
        log.info("Поток {} начал выполнение задачи: {}", Thread.currentThread().getName(), chore);
        try {
            int duration = random.nextInt(1000, 3000);
            Thread.sleep(duration);
            log.info("Поток {} завершил задачу: {} за {} мс", Thread.currentThread().getName(), chore, duration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.info("Поток {} был прерван во время выполнения задачи: {}", Thread.currentThread().getName(), chore);
        }
    }
}
