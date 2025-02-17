package school.faang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class Trial implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(Trial.class);
    private static final Random random = new Random();
    private final String knightName;
    private final String trialName;

    public Trial(String knightName, String trialName) {
        validateString(knightName, "Knight's name");
        validateString(trialName, "Trial's name");
        this.knightName = knightName;
        this.trialName = trialName;
    }

    @Override
    public void run() {
        try {
            logger.info("{} started trial {}", knightName, trialName);
            Thread.sleep(1000 + random.nextInt(2000));
            logger.info("{} finished trial {}", knightName, trialName);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private void validateString(String string, String message) {
        if (string == null || string.isBlank()) {
            throw new IllegalArgumentException(message + " can't be null or blank.");
        }
    }
}
