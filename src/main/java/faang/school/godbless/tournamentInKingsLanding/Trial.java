package faang.school.godbless.tournamentInKingsLanding;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Trial implements Runnable{
    private final String trialName;
    @Setter
    private String knightName = "Unknown";

    public Trial(String trialName) {
        this.trialName = trialName;
    }

    @Override
    public void run() {
        System.out.println("Sir " + knightName + " started " + trialName);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Sir " + knightName + " finished " + trialName);
    }
}
