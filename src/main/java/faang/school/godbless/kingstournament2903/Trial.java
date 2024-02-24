package faang.school.godbless.kingstournament2903;

import lombok.Getter;

import java.util.Random;

@Getter
public class Trial implements Runnable {
    private Knight knight;
    private String trialName;

    public Trial(Knight knight, String trialName) {
        this.knight = knight;
        this.trialName = trialName;
    }

    @Override
    public void run() {
        synchronized (this.getKnight()) {
            String knightName = this.knight.getName();
            Random random = new Random();
            System.out.printf("%s is on %s. May the power of gods be with you!%n", knightName, this.trialName);
            try {
                Thread.sleep(random.nextLong(5_000L, 10_000L));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.printf("%s has made it through!%n", knightName);
        }
    }
}
