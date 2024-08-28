package faang.school.godbless.bjs2_23503;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        try {
            System.out.println(knightName + " started " + trialName);
            Thread.sleep(3000L);
            System.out.println(knightName + " finished " + trialName);
        } catch (InterruptedException e) {
            System.out.println("Trial was interrupted");
        }
    }
}
