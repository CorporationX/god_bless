package school.faang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.util.Random;

public class Chore implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(Chore.class);
    private final Random random = new Random();
    private final String title;

    public Chore(String title) {
        validateTitle(title);
        this.title = title;
    }

    @Override
    public void run() {
        try {
            logger.info("{} started work on {} at {}.", Thread.currentThread().getName(), Instant.now(), title);
            Thread.sleep(random.nextInt(3000));
            logger.info("{} has  been completed at {}.", title, Instant.now());
        } catch (InterruptedException e) {
            logger.info("{} hasn't been completed.", title);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private void validateTitle(String title) {
        if (title == null) {
            throw new IllegalArgumentException("Title can't be null.");
        }
    }
}
