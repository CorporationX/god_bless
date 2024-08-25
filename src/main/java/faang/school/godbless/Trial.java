package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@Slf4j
public class Trial implements Runnable{
    private String knighName;
    private String trialName;

    @Override
    public void run() {
        try {
            log.info(knighName + " is starting trial: " + trialName);
            Thread.sleep(5000L);
            log.info(knighName + " finished trial: "+ trialName);
        } catch (InterruptedException e) {
            log.info(knighName + " was interrupted during trial: "+ trialName);
        }
    }
}
