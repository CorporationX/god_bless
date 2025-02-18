package school.faang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.util.Random;

public class Pig1Thread extends PigThread {
    private static final Logger logger = LoggerFactory.getLogger(Pig1Thread.class);
    private static final Random random = new Random();
    private static final int MIN_BUILDING_TIME = 1000;
    private static final int MAX_BUILDING_TIME = 2000;

    public Pig1Thread() {
        super("Nif-Nif", "straw");
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
