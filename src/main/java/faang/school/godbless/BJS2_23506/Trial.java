package faang.school.godbless.BJS2_23506;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable{
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.println(knightName + " is performing the trial '" + trialName + "'");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
