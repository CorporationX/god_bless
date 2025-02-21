package school.faang.tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;
    public static final int TRIAL_TIME = 2000;

    @Override
    public void run() {
        log.info("The trial {} has started", trialName);
        try {
            Thread.sleep(TRIAL_TIME);
        } catch (InterruptedException e) {
            Thread.interrupted();
            throw new RuntimeException("The trial was interrupted");
        }
    }
}
