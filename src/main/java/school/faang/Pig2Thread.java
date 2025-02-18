package school.faang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.util.Random;

public class Pig2Thread extends PigThread {
    private static final Logger logger = LoggerFactory.getLogger(Pig2Thread.class);
    private static final Random random = new Random();
    private static final int MIN_BUILDING_TIME = 2000;
    private static final int MAX_BUILDING_TIME = 3000;

    public Pig2Thread() {
        super("Nuf-Nuf", "sticks");
    }

    @Override
    public void run() {
        logger.info("{} started building the house using {} at {}",
                getPigName(), getMaterial(), Instant.now());
        try {
            Thread.sleep(MIN_BUILDING_TIME + random.nextInt(MAX_BUILDING_TIME));
        } catch (InterruptedException e) {
            logger.info("{} failed building the house using {} at {}",
                    getPigName(), getMaterial(), Instant.now());
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        logger.info("{} finished building the house using {} at {}",
                getPigName(), getMaterial(), Instant.now());
    }
}
