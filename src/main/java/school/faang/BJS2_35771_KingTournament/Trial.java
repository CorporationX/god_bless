package school.faang.BJS2_35771_KingTournament;

import lombok.AllArgsConstructor;

import java.util.concurrent.ThreadLocalRandom;

@AllArgsConstructor
public class Trial implements Runnable {
    private static final int MILLISECONDS_IN_SECOND = 1000;
    private static final int MIN_SLEEP_TIME_SECONDS = 1;
    private static final int MAX_SLEEP_TIME_SECONDS = 5;

    private String knightName ;
    private String trialName;

    @Override
    public void run() {
        int sleepTime = ThreadLocalRandom.current().nextInt(MIN_SLEEP_TIME_SECONDS, MAX_SLEEP_TIME_SECONDS) * MILLISECONDS_IN_SECOND;
        System.out.printf("The trial %s for knight %s has begun!\n", trialName, knightName);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            throw new IllegalStateException(
                    String.format("The thread %s was interrupted while its execution!", Thread.currentThread().getName()),
                    e
            );
        }
    }
}
