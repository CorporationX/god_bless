package school.faang.task_48189;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Getter
@Slf4j
@RequiredArgsConstructor
public class Chore implements Runnable {
    private final String chore;

    @Override
    public void run() {
        try {
            log.info("{} started to solve the problem of {}", Thread.currentThread().getName(), getChore());
            Thread.sleep(new Random().nextInt(2000, 10000));
            log.info("The {} solved the problem of {}", Thread.currentThread().getName(), getChore());
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }
}
