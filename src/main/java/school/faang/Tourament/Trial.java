package school.faang.Tourament;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        try {
            System.out.println("Trial: " + trialName + " for knight " + knightName + " started!");
            Thread.sleep(500);
            System.out.println("Trial: " + trialName + " for knight " + knightName + " finished!");
        } catch (InterruptedException e) {
            System.out.println("Trial has been interrupted");
            throw new RuntimeException(e);
        }

    }
}
