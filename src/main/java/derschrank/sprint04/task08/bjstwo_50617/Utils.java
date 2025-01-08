package derschrank.sprint04.task08.bjstwo_50617;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class Utils {
    public static final int HUNDRED_PERCENT = 100;
    public static final Random RANDOM = new Random();

    public static void doSleepForCurrentThread(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            log.error("Service was interrupted:\n" + e);
        }
    }

    public static void makeRandomTimeException(Random rnd, int probabilityOfExceptionsInPercent) {
        if (rnd.nextInt(HUNDRED_PERCENT) < probabilityOfExceptionsInPercent) {
            throw new RuntimeException("The raven got lost");
        }
    }
}
