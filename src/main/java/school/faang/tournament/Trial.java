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

    @Override
    public void run() {
        log.info("The trial " + trialName + " has started");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.interrupted();
            throw new RuntimeException("The trial was interrupted");
        }
    }
}
