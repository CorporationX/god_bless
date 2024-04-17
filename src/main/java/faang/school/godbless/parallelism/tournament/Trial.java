package faang.school.godbless.parallelism.tournament;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@ToString
@AllArgsConstructor
@Slf4j
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        log.info("Executing " + trialName + " by knight " + knightName);

        try {
            Thread.sleep(new Random().nextInt(1000, 5000));
        } catch (InterruptedException e) {
            log.error(trialName + " was interrupted.", e);
        }

        log.info(trialName + " was executed by knight" + knightName);
    }
}
