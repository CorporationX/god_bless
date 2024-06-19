package faang.school.godbless.parallelism.tournament;

import lombok.Getter;

@Getter
public class Trial implements Runnable {
    private String knightName;
    private String trialName;
    private long TRIAL_TIME = 1000L;

    public Trial(String knightName, String trialName) {
        if (knightName.isBlank() || trialName.isBlank()) {
            throw new IllegalArgumentException("Parameter is empty!");
        }
        this.knightName = knightName;
        this.trialName = trialName;
    }

    @Override
    public void run() {
        System.out.println(String.format("Knight: %s begin trial: %s", this.knightName, this.trialName));
        try {
            Thread.sleep(TRIAL_TIME);
            System.out.println(String.format("The knight: %s successfully completed the trial: %s", this.knightName, this.trialName));
        } catch (InterruptedException e) {
            System.out.println(String.format("The knight: %s interrupted the trial: %s", this.knightName, this.trialName));
            throw new RuntimeException(e);
        }
    }
}
