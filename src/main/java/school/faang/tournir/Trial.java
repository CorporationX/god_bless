package school.faang.tournir;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;
    private static final int SLEEP_MILLISECONDS = 2000;

    @Override
    public void run() {
        try {
            log.info("Trial {} has started", trialName);
            Thread.sleep(SLEEP_MILLISECONDS);
        } catch (InterruptedException exception) {
            log.error("Thread is interrupted {}", exception.getMessage());
            Thread.currentThread().interrupt();
        }
        log.info("Trial {} has ended", trialName);
    }
}
