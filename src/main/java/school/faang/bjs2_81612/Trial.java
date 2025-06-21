package school.faang.bjs2_81612;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        try {
            log.info("{} начинает испытание: {}", knightName, trialName);
            TimeUnit.SECONDS.sleep(2);
            log.info("{} закончил испытание: {}", knightName, trialName);
        } catch (InterruptedException e) {
            log.error("Knight {} interrupted while doing the trial {}", knightName, trialName);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
