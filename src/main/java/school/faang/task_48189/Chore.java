package school.faang.task_48189;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Getter
@Slf4j
@RequiredArgsConstructor
public class Chore implements Runnable {
    private static final int MIN_SLEEP_TIME = 2000;
    private static final int MAX_SLEEP_TIME = 10000;

    private final String chore;

    @Override
    public void run() {
        log.info("{} started to solve the problem of {}", Thread.currentThread().getName(), getChore());
        try {
            Thread.sleep(new Random().nextInt(MIN_SLEEP_TIME, MAX_SLEEP_TIME));
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        log.info("The {} solved the problem of {}", Thread.currentThread().getName(), getChore());
    }
}