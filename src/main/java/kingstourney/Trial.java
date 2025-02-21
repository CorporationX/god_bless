package kingstourney;

import lombok.Getter;

import java.util.Random;
import java.util.logging.Logger;

@Getter
public class Trial implements Runnable {
    private static final Logger logger = Logger.getLogger(Trial.class.getName());
    private final String knightName;
    private final String trialName;
    private final Random random = new Random();

    public Trial(String knightName, String trialName) {
        this.knightName = knightName;
        this.trialName = trialName;
    }

    @Override
    public void run() {
        try {
            String threadName = Thread.currentThread().getName();
            logger.info(threadName + ": " + trialName + " is starting by " + knightName);
            Thread.sleep(1000 + random.nextInt(2000));
            logger.info(threadName + ": " + trialName + " has finished by " + knightName);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.severe(knightName + "'s was interrupted!");
        }
    }
}
