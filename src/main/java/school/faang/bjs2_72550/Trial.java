package school.faang.bjs2_72550;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record Trial(String knightName, String trialName) implements Runnable {
    @Override
    public void run() {
        log.info(String.format("%s has been started %s", knightName, trialName));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            log.error("Thread was destroyed");
        }
        log.info(String.format("%s has been finished %s", knightName, trialName));
    }
}
