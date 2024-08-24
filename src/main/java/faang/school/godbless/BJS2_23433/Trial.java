package faang.school.godbless.BJS2_23433;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {

        try {
            log.info("Trial {} has started by {}", trialName, knightName);
            Thread.sleep(3000);
            log.info("Trial {} was ended by {}", trialName, knightName);
        } catch (InterruptedException e) {
            log.error("Something gone wrong with thread: {}", e.getMessage());
        }
    }
}
