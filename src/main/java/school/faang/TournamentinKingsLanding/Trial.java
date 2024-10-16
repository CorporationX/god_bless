package school.faang.TournamentinKingsLanding;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Trial implements Runnable{
    private final String trialName;
    private final String knightName;

    @Override
    public void run() {
        System.out.println(trialName + " trial started for knight: " + knightName);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Something went wrong", e);
        }
    }
}
