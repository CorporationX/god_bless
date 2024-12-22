package school.faang.sprint_3.task_47592;

import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
public class Trial implements Runnable {
    private static final int TRIAL_DURATION = 5000;

    private String knightName;
    private final String trialName;

    @Override
    public void run() {
        try {
            System.out.printf("%s starts trial %s\n", knightName, trialName);
            Thread.sleep(TRIAL_DURATION);
            System.out.printf("%s ends trial %s\n", knightName, trialName);
        } catch (InterruptedException e) {
            System.out.println(trialName + " interrupted");
            Thread.currentThread().interrupt();
        }
    }
}
