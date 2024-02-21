package faang.school.godbless.royalHarbor;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        try {
            System.out.println(getKnightName() + " tryes to do " + getTrialName());
            Thread.sleep(4500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
