package school.faang.task_48173;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Trial implements Runnable {
    private static final int TRIAL_DURATION = 3000;
    private final String knightName;
    private final String trialName;

    public Trial(String knightName, String trialName) {
        this.knightName = knightName;
        this.trialName = trialName;
    }

    @Override
    public void run() {
        System.out.printf("Thread %s has started event: \"The trial \"%s\" for %s is start!\"\n",
                Thread.currentThread().getName(), trialName, knightName);
        try {
            Thread.sleep(TRIAL_DURATION);
            System.out.printf("Thread %s has started event: \"The trial \"%s\" for %s is done!\"\n",
                    Thread.currentThread().getName(), trialName, knightName);
        } catch (InterruptedException e) {
            log.info("The trial {} with {} was interrupted: {}", trialName, knightName, e.getMessage());
        }
    }
}
