package school.faang.spring3.task_47631;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@AllArgsConstructor
@Slf4j
public class Trial implements Runnable {
    private static final int MIN_TIME = 1000;
    private static final int MAX_TIME = 5000;

    private String knightName;
    private String trialName;

    @Override
    public void run() {
        try {
            log.info("{} started {}", knightName, trialName);
            Thread.sleep(new Random().nextInt(MIN_TIME, MAX_TIME));
            log.info("{} finished {}", knightName, trialName);
        } catch (InterruptedException e) {
            log.error("something went wrong with method sleep");
        }

    }
}
