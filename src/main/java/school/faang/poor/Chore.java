package school.faang.poor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Chore implements Runnable {

    private final String chore;

    @Override
    public void run() {
        log.info("Начинаем выполнять {}", this.chore);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
        log.info("Закончили {}", this.chore);
    }
}