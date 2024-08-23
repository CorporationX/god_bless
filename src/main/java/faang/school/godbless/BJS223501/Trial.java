package faang.school.godbless.BJS223501;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        try {
            System.out.println(knightName + " has start trials: " + trialName);
            Thread.sleep(5000);
            System.out.println(knightName + " has finish trials: " + trialName);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
