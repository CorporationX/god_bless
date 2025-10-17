package school.faang.bjs2_89600;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Getter
@Setter
public class Trial implements Runnable {
    private static final int TRIAL_DURATION = 7000;
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        log.debug("{} начал первую попытку {}", knightName, trialName);
        try {
            Thread.sleep(TRIAL_DURATION);
            log.debug("{} справился!", knightName);
        } catch (InterruptedException e) {
            log.error("Испытание не закончилось, рыцарь отбросил коньки...");
        }
    }
}
