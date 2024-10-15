package school.faang.m1s3.bjs2_35766_kingsLanding;

import lombok.RequiredArgsConstructor;

import java.time.LocalTime;
import java.util.Random;

@RequiredArgsConstructor
public class Trial implements Runnable {
    private final String knightName;
    private final String trialName;

    @Override
    public void run() {
        System.out.printf("#%d %s: %s starts the trial %s%n",
                Thread.currentThread().getId(), LocalTime.now(), knightName, trialName);

        try {
            Thread.sleep(new Random().nextInt(1, 10) * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("#%d %s: %s finished the trial %s%n",
                Thread.currentThread().getId(), LocalTime.now(), knightName, trialName);
    }
}
