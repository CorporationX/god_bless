package faang.school.godbless.tournament_in_kings_landing;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.println(knightName + " passed the " + trialName + "!");
    }
}
