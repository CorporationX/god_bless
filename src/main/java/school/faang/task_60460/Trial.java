package school.faang.task_60460;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable {
    private static final long SLEEP_TIME = 1000;
    private final String knightName;
    private final String trialName;

    @Override
    public void run() {
        System.out.printf("%s began the trial: %s\n", knightName, trialName);
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        System.out.printf("%s has completed the trial: %s\n", knightName, trialName);
    }
}
