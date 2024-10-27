package school.faang.godbless.bjs2_35772;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Trial implements Runnable {
    private static final int TRIAL_COMPLETION_TIME = 5000;

    private String knightName;
    private String trialName;

    @Override
    public void run() {
        log.info("Knight {} started a trial. Trial: {}", knightName, trialName);
        try {
            Thread.sleep(TRIAL_COMPLETION_TIME);
        } catch (InterruptedException e) {
            log.warn("Thread interrupted while trial");
            Thread.currentThread().interrupt();
        }
        log.info("Knight {} completed a trial. Trial: {}", knightName, trialName);
    }
}
