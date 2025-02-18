package school.faang.theywereverynice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public class Chore implements Runnable {
    private static final long MAX_TIME_EXECUTED_CHORE = 7000;
    private static final long MIN_TIME_EXECUTED_CHORE = 1000;

    private String title;

    @Override
    public void run() {
        try {
            Thread.sleep((long) (Math.random() * MAX_TIME_EXECUTED_CHORE + MIN_TIME_EXECUTED_CHORE));
            log.info("{} execute task: {}", Thread.currentThread().getName(), this.getTitle());
        } catch (InterruptedException exception) {
            log.error("Thread has been interrupted. Name thread: {}\nException: {}\nStack trace:{}",
                    Thread.currentThread().getName(), exception, exception.getStackTrace());
            Thread.currentThread().interrupt();
        }
    }
}
