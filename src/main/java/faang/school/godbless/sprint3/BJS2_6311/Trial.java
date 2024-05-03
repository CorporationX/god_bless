package faang.school.godbless.sprint3.BJS2_6311;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Trial implements Runnable {
    private final String knightName;
    private final String trialName;

    @Override
    public void run() {
        System.out.println(knightName + " starts the trial: " + trialName);

        try {
            Thread.sleep(new Random().nextInt(5000) + 1000);
        } catch (InterruptedException e) {
            System.out.println(knightName + " was interrupted during the trial " + trialName);
            Thread.currentThread().interrupt();
        }

        System.out.println(knightName + " completed the trial: " + trialName);
    }
}