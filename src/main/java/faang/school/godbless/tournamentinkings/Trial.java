package faang.school.godbless.tournamentinkings;


import lombok.RequiredArgsConstructor;

import java.util.Random;

@RequiredArgsConstructor
public class Trial implements Runnable {
    private final String knightName;
    private final String trialName;
    private Random random = new Random();

    @Override
    public void run() {
        System.out.println("Trial " + trialName + " at the knight's " + knightName + " began");
        try {
            Thread.sleep(random.nextInt(10000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Trial " + trialName + " at the knight's " + knightName + " went well");
    }
}
