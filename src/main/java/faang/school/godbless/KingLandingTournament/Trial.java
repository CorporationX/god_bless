package faang.school.godbless.KingLandingTournament;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable{
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("Knight " + knightName + " is performing trial: " + trialName);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
