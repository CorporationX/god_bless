package faang.school.godbless.BJS2_23556;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable {

    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.println(knightName + " is starting the trail " + trialName);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(knightName + " has completed the trail " + trialName);
    }
}
