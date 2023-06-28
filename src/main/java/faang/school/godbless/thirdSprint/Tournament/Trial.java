package faang.school.godbless.thirdSprint.Tournament;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    public void run() {
        System.out.println("Knight " + knightName + " starting to pass the trial " + trialName);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Cheers! " + knightName + " successfully complete the trial  " + trialName);
    }
}
