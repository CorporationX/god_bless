package faang.school.godbless.tournament_in_kings_landing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Trial implements Runnable{
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.println("Knight " + knightName + " performs the trial " + trialName);
    }
}
