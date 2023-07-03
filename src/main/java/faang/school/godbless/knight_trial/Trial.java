package faang.school.godbless.knight_trial;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Trial implements Runnable {

    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.println("Knight " + knightName + " is attempting trial: " + trialName);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Knight " + knightName + " has completed trial: " + trialName);
    }
}
