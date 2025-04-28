package school.faang.bjs2_73073;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class ChoreTask implements Runnable {
    private Chore chore;

    @Override
    public void run() {
        log.info("Thread '{}' has started chore '{}'", Thread.currentThread().getName(), chore);
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            throw new IllegalStateException("Thread was interrupted during chore execution: " + chore, e);
        }
        log.info("Thread '{}' has finished chore '{}'", Thread.currentThread().getName(), chore);
    }
}