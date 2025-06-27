package school.faang.extremelypoor;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Getter
@RequiredArgsConstructor
@Slf4j
public class Chore implements Runnable {
    private final String chore;

    private static final int executionTime = 1000;

    @Override
    public void run() {
        try {
            log.info("{} is doing chore {}", Thread.currentThread().getName(), chore);
            Thread.sleep(executionTime);
            log.info("{} done", chore);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("Chore {} was interrupted", chore, e);
        }
    }
}
