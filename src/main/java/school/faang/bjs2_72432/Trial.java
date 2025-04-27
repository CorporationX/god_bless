package school.faang.bjs2_72432;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Trial implements Runnable {
    private static final int TRIAL_DURATION = 3000;

    private final String knightName;
    private final String trialName;

    @Override
    public void run() {
        try {
            log.info("{} started trial {}", knightName, trialName);
            Thread.sleep(TRIAL_DURATION);
            log.info("{} finished trial {}", knightName, trialName);
        } catch (InterruptedException e) {
            log.error("Interrupted exception with message {} was thrown", e.getMessage());
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}