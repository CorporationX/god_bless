package faang.school.godbless.multithreading.parallelism.tournament;

import lombok.Setter;

public class Trial implements Runnable {
    @Setter
    private String knightName;
    private final String trialName;

    public Trial(String trialName) {
        this.trialName = trialName;
    }

    @Override
    public void run() {
        System.out.println(knightName + " is participating in the " + trialName + " trial.");
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(knightName + " has completed the " + trialName + " trial.");
    }
}
