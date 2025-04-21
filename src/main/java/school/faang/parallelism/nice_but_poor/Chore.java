package school.faang.parallelism.nice_but_poor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Chore implements Runnable {

    private final String chore;

    @Override
    public void run() {

        log.info("{} started {}", Thread.currentThread().getName(), chore);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.info("{} with a chore {} was interrupted", Thread.currentThread().getName(), chore);
            throw new IllegalStateException("Thread shutdown failed");
        }

        log.info("{} finished {}", Thread.currentThread().getName(), chore);
    }
}
