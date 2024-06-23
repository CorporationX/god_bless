package faang.school.godbless;

import java.util.Random;

public class Trial implements Runnable {
    private final String knightName;
    private final String trialName;

    public Trial(String knightName, String trialName) {
        this.knightName = knightName;
        this.trialName = trialName;
    }

    @Override
    public void run() {
        System.out.printf("%s started the trial: %s\n", knightName, trialName);
        try {
            Thread.sleep(new Random().nextInt(10000) + 1000);
            System.out.printf("%s finished the trial: %s\n", knightName, trialName);
        } catch (InterruptedException e) {
            throw new RuntimeException(String.format("Knight %s was interrupted on the trial: %s\n", knightName, trialName), e);
        }
    }
}
