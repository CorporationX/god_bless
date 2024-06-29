package faang.school.godbless.multithreading_parallelism.task_6;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable {
    private final String knightName;
    private final String trialName;

    private static final int TRIAL_TIME = 5000;

    @Override
    public void run() {
        System.out.println(knightName + " Started trial: " + trialName);
        try {
            Thread.sleep(TRIAL_TIME);
        } catch (InterruptedException e) {
            System.out.println("An error occurred " + e + " when" + knightName + " was doing trial: " + trialName);
        }
        System.out.println(knightName + " Ended " + "Trial: " + trialName);
    }
}
