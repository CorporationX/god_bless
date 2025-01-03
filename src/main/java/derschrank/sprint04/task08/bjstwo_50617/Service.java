package derschrank.sprint04.task08.bjstwo_50617;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class Service {
    public static final Random RANDOM = new Random();

    public static void toSleep(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            log.error("Service was interrupted:\n" + e);
        }
    }

    public static void makeRandomTimeException(Random rnd, int procentOfException) {
        if (rnd.nextInt(100) < procentOfException) {
            throw new RuntimeException("The raven got lost");
        }
    }
}
