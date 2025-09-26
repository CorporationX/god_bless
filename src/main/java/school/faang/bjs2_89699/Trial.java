package school.faang.bjs2_89699;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        try {
            log.info("{} начинает испытание {}.", knightName, trialName);
            Thread.sleep(3000);
            log.info("{} заканчивает испытание {}.", knightName, trialName);
        } catch (InterruptedException e) {
            log.error("Испытание {} прервано.", trialName);
            Thread.currentThread().interrupt();
        }
    }
}
