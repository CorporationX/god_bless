package school.faang.tournamentkinglanding;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable {
    private final String knightName;
    private final String trialName;

    @Override
    public void run() {
        try {
            System.out.println(knightName + " begins the trial: " + trialName);

            Thread.sleep((int) (Math.random() * 2000 + 1000));

            System.out.println(knightName + " has completed the trial: " + trialName);
        } catch (InterruptedException e) {
            System.out.println("The trial " + trialName + " for " + knightName + " was interrupted.");
            Thread.currentThread().interrupt();
        }
    }
}
