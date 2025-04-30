package school.faang.tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Getter
@Slf4j
public class Trial implements Runnable {
    private final String knightName;
    private final String trialName;

    @Override
    public void run() {
        log.info("{} начинает испытание ", trialName);
        try {
            int duration = (int) (Math.random() * 3 + 1);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.info("Испытание прервано : {}", trialName);
        }
        log.info("{}  успешно завершил испытание {}", knightName, trialName);

    }
}
