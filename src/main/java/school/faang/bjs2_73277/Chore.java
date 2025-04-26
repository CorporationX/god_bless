package school.faang.bjs2_73277;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class Chore implements Runnable {
    private final String chore;
    private final long sleepTime = 3_000;

    public void run() {
        try {
            log.info("The thread {} started with the task {}.", Thread.currentThread().getName(), chore);
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            log.error("Chore interrupted. {}.", e.getMessage());
        }
    }
}
