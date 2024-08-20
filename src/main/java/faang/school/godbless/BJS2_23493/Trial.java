package faang.school.godbless.BJS2_23493;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Trial implements Runnable {

    private final String knightName;
    private final String trialName;

    @Override
    public void run() {
        System.out.println(knightName + " started " + trialName);

        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            System.out.println("Trial " + trialName + " interrupted");
        }

        System.out.println(knightName + " ended " + trialName);
    }
}
