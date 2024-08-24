package faang.school.godbless.tournament;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;


    public void run() {
        try {
            log.info("Trial {} has started by           {}", trialName, knightName);
            Thread.sleep(3000);
            log.info("Trial {} was ended by           {}", trialName, knightName);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Something gone wrong with thread: {}", e.getMessage());

        }

    }

}
