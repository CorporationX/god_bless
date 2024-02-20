package faang.school.godbless.kingstournament2903;

import lombok.Getter;

import java.util.Random;

@Getter
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    public Trial(String knightName, String trialName) {
        this.knightName = knightName;
        this.trialName = trialName;
    }

    @Override
    public void run() {
        String knightName = this.knightName;
        Random random = new Random();
        System.out.printf("%s is on %s. May the power of gods be with you!%n", knightName, this.trialName);
        try {
            Thread.sleep(random.nextLong(5_000L, 10_000L));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
