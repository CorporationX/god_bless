package school.faang.kingtournament;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Trial implements Runnable {
    private static final int SECOND_TIMER = 3000;
    private final String trialName;
    private final String knightName;


    @Override
    public void run() {
        try {
            log.info("{} начал испытание {} ", knightName, trialName);
            Thread.sleep(SECOND_TIMER);
            log.info("{} закончил испытание {} закончилось", knightName, trialName);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error(e.getMessage(), e);
        }
    }
}
