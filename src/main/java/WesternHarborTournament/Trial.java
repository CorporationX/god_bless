package WesternHarborTournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": " + getKnightName() + " " + getTrialName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
