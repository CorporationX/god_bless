package school.faang.bjs2_89573;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Getter
@AllArgsConstructor
@Slf4j
public class Trial implements Runnable {
    private static final int MIN_TIME_EXECUTION = 1000;
    private static final int MAX_TIME_EXECUTION = 15000;
    private final String knightName;
    private final String trialName;

    @Override
    public void run() {
        try {
            log.info("The test {} for {} has begun", trialName, knightName);
            Thread.sleep(new Random().nextInt(MIN_TIME_EXECUTION, MAX_TIME_EXECUTION));
            log.info("The test {} for {} successfully completed", trialName, knightName);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("The test {} for {} was interrupted", trialName, knightName);
        }
    }
}
