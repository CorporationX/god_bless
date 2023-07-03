package faang.school.godbless.multithreadingS4.royalHarbor;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@Getter
@AllArgsConstructor
public class Trial implements Runnable {
    private static final int COEF_SLEEP = 250;
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.printf("%s began the trial: %s%n", knightName, trialName);

        try {
            Thread.sleep(new Random().nextInt(50) * COEF_SLEEP);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("\t%s has finished the trial: %s%n", knightName, trialName);
    }
}
