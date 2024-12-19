package school.faang.sprint3.task_48346;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Chore implements Runnable {

    private static final int SECONDS_TO_SLEEP = 5;
    private final String chore;

    @Override
    public void run() {
        log.info("Hello, I am thread {} and I am doing {}", Thread.currentThread().getName(), chore);
        try {
            Thread.sleep(SECONDS_TO_SLEEP * 1000);
        } catch (InterruptedException e) {
            log.error("Thread {} was interrupted and has not completed the task", Thread.currentThread().getName());
            e.printStackTrace();
            return;
        }

        log.info("\nI am thread {} and I've completed my task successfully", Thread.currentThread().getName());
    }
}
