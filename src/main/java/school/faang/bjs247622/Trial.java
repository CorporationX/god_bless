package school.faang.bjs247622;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public class Trial implements Runnable {
    private final String knightName;
    private final String trialName;

    @Override
    public void run() {
        try {
            log.info("The trial has begun");
            Thread.sleep(4000);
            log.info("The trial has finished");
        } catch (InterruptedException e) {
            log.error("The thread was interrupted {} ", Thread.currentThread().getName());
        }
    }
}