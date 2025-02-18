package school.faang.task_60460;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable {
    private final String knightName;
    private final String trialName;

    @Override
    public void run() {
        System.out.printf("%s began the trail: %s\n", knightName, trialName);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        System.out.printf("%s has completed the trial: %s\n", knightName, trialName);
    }
}
