package faang.school.godbless.royal.tournament;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Slf4j
@Setter
public class Trial implements Runnable {
    private static final int UPPER_BOUND_FOR_TRIAL = 5;
    private static final int LOWER_BOUND_FOR_TRIAL = 1;

    private String knightName;
    private String trialName;

    public Trial(String trialName) {
        this.trialName = trialName;
    }

    @Override
    public void run() {
        try {
            System.out.printf("%s started %s\n", knightName, trialName);
            int timeForTrial = new Random().nextInt(UPPER_BOUND_FOR_TRIAL) + LOWER_BOUND_FOR_TRIAL;
            TimeUnit.SECONDS.sleep(timeForTrial);
            System.out.printf("%s ended %s\n", knightName, trialName);
        } catch (InterruptedException exception) {
            log.error(String.format("Thread was interrupted while %s did trial \"%s\"", knightName, trialName), exception);
            Thread.currentThread().interrupt();
        }
    }
}
