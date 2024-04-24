package faang.school.godbless.theTournament;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Trial implements Runnable{
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.println(knightName + " is passing a trail "+trialName);
    }
}
