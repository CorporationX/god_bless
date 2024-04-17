package faang.school.godbless.kingslanding;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;
    @Override
    public void run() {
        System.out.println(knightName + " start trial: " + trialName);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Trial been failed");
        }
        System.out.println(knightName + " finished trial " + trialName);
    }
}
