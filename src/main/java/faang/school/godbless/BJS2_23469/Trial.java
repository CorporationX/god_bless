package faang.school.godbless.BJS2_23469;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Trial implements Runnable {
    private final String knightName;
    private final String trialName;
    private final Random random = new Random();


    @Override
    public void run() {
        System.out.printf("%S: %s starts trial (%s)\n", Thread.currentThread().getName(), knightName, trialName);
        try {
            Thread.sleep(getMilliseconds());
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread error");
        }
        System.out.printf("%S: %s ends trial (%s)\n", Thread.currentThread().getName(), knightName, trialName);
    }

    private int getMilliseconds() {
        return (random.nextInt(5) + 1) * 1000;
    }
}
