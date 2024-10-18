package school.faang.royal.tournament;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Slf4j
@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;
    private int durationTrialInSeconds;

    @Override
    public void run() {
        System.out.println("Испытание " + trialName + " началось!");
        try {
            TimeUnit.SECONDS.sleep(durationTrialInSeconds);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            log.error(Arrays.toString(e.getStackTrace()));
        }
        System.out.println("Рыцарь " + knightName + " завершил испытание " + trialName);
    }
}
