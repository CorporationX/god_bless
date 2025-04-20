package school.faang.poor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Chore implements Runnable {

    private final String chore;

    @Override
    public void run() {
        log.info("{} начинает выполнять {}", Thread.currentThread().getName(), this.chore);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("{} закончил {}", Thread.currentThread().getName(), this.chore);
    }
}