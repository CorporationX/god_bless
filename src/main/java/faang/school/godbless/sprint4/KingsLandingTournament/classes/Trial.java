package faang.school.godbless.sprint4.KingsLandingTournament.classes;

import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.Random;

@AllArgsConstructor
@Setter
public class Trial implements Runnable {
    private final String knightName;
    private final String trialName;

    @Override
    public void run() {
        System.out.println(knightName + " starts trial " + trialName);

        try {
            Thread.sleep(new Random().nextLong(1_000, 5_000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(knightName + " finishes trial " + trialName);
    }
}
