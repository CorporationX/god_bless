package school.faang.kingstourney;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@AllArgsConstructor
public class Trial implements Runnable {
    private final String knightName;
    private final String trialName;
    private final int trialTime;

    @Override
    public void run() {
        log.info("{} приступил к выполнению испытания - {}", knightName, trialName);
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, trialTime));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Поток прерван {}", e.getMessage(), e);
        }
        log.info("{} выполнил испытание - {}", knightName, trialName);
    }
}
