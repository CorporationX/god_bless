package faang.school.godbless.thekingslandingtournament;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable {
    private final String knightName;
    private final String trialName;

    @Override
    public void run() {
        try {
            System.out.printf("%s is starting trial: %s\n", knightName, trialName);
            Thread.sleep(5000L);
            System.out.printf("%s finished trial: %s\n", knightName, trialName);
        } catch (InterruptedException e) {
            System.out.printf("%s was interrupted during trial: %s\n", knightName, trialName);
            Thread.currentThread().interrupt();
        }
    }
}