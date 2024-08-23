package faang.school.godbless.BJS223647;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.println(knightName + " is on " + trialName + " trial");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
//            e.printStackTrace();
        }
        System.out.println(knightName + " has completed " + trialName + " trial");
    }
}
