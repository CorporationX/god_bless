package school.faang.extremelypoor;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Getter
@RequiredArgsConstructor
@Slf4j
public class Chore implements Runnable {
    private final String chore;

    @Override
    public void run() {
        try {
            log.info("{} is doing chore {}", Thread.currentThread().getName(), chore);
            Thread.sleep(1000);
            log.info("{} done", chore);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("Chore {} was interrupted", chore, e);
        }
    }
}
