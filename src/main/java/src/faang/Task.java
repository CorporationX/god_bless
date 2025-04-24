package src.faang;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Slf4j
public class Task implements Runnable {
    private static final int MAX_DURATION_EXECUTING_TASK = 5;

    private final String name;
    private final String task;
    private final Random random;
    private final CountDownLatch countDownLatch;

    @Override
    public void run() {
        log.info("{} начал выполнять задачу: {}", name, task);
        sleep();
    }

    private void sleep() {
        try {
            TimeUnit.SECONDS.sleep(random.nextInt(MAX_DURATION_EXECUTING_TASK));
        } catch (InterruptedException e) {
            log.info("Выполенение задачи: {} прервано.", task);
            Thread.currentThread().interrupt();
        } finally {
            countDownLatch.countDown();
        }
    }
}
