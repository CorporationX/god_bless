package school.faang.kings_landing_tourney_BJS2_35750;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Trial {
    private String knightName;
    private String trialName;

    public void run() {
        int sleepFrom = 1000;
        int sleepTo = 3000;
        System.out.printf("%s for %s has started\n", trialName, knightName);
        try {
            Thread.sleep(new Random().nextInt(sleepFrom, sleepTo));
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
