package school.faang.TheBigBangTheory;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
public class Task implements Runnable {
    private static final int ONE_SEC_SLEEP = 1;
    private final String name;
    private final String task;

    @SuppressWarnings({"checkstyle:RightCurly", "checkstyle:Indentation"})
    @Override
    public void run() {
        log.info("Start {} task {}", name, task);
        try {
            TimeUnit.SECONDS.sleep(ONE_SEC_SLEEP);
        } catch (InterruptedException e) {
            log.error("Task {} {} interrupted", name, task, e);
            Thread.currentThread().interrupt();
        }
    }
}