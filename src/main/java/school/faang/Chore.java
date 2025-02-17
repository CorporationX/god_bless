package school.faang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Chore implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(Chore.class);
    private final String title;

    public Chore(String title) {
        validateTitle(title);
        this.title = title;
    }

    @Override
    public void run() {
        try {
            logger.info("{} works on {}.", Thread.currentThread().getName(), title);
            Thread.sleep(1000);
            logger.info("{} have been completed.", title);
        } catch (InterruptedException e) {
            logger.info("{} haven't been completed.", title);
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
