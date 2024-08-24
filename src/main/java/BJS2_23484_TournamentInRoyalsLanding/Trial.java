package BJS2_23484_TournamentInRoyalsLanding;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Trial implements Runnable {
    private final String knightName;
    private final String trialName;

    @Override
    public void run() {
        System.out.println(getTrialName() + " has started by " + getKnightName());
        try {
            System.out.println(Thread.currentThread() + " is in progress!...");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(getTrialName() + " by " + getKnightName() + " has been completed!");
    }
}
