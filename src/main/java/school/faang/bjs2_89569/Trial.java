package school.faang.bjs2_89569;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;
    private static final int COUNT_SLEEP = 5000;

    public void run() {
        System.out.printf("Trial %s for %s start.%n", trialName, knightName);
        try {
            Thread.sleep(COUNT_SLEEP);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Trial %s for %s finished.%n", trialName, knightName);
    }
}
