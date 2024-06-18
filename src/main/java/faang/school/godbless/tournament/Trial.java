package faang.school.godbless.tournament;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@AllArgsConstructor
@Slf4j
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.println(knightName + " is processing " + trialName);
        try {
            Thread.sleep(new Random().nextInt(1, 5) * 1000L);
            System.out.println("The trial: " + trialName + " has been passed successfully by " + knightName);
        } catch (InterruptedException e) {
            log.warn(knightName + " could not pass " + trialName);
        }
    }
}
