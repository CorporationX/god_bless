package faang.school.godbless.parallelism.kingtournament;

import lombok.Setter;

@Setter
public class Trial implements Runnable {
    private String trialName;
    private String knightName;

    public Trial(String trialName) {
        this.trialName = trialName;
    }

    private Trial(String trialName, String knightName) {
        this.trialName = trialName;
        this.knightName = knightName;
    }

    public Trial copy() {
        return new Trial(trialName, knightName);
    }
    @Override
    public void run() {
        System.out.printf("%s выполняет испытаение %s\n", knightName, trialName);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("%s закончил испытаение %s\n", knightName, trialName);
    }
}
