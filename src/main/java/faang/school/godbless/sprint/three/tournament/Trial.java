package faang.school.godbless.sprint.three.tournament;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        try {
            System.out.printf("The %s starts the trial %s%n", knightName, trialName);
            Thread.sleep(Constants.TRIAL_DURATION);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
