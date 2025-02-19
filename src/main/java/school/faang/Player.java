package school.faang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Player {
    private static final Logger logger = LoggerFactory.getLogger(Player.class);
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                logger.info("Music is already playing.");
            } else {
                isPlaying = true;
                logger.info("Music is playing.");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (!isPlaying) {
                logger.info("Music is already paused.");
            } else {
                isPlaying = false;
                logger.info("Music paused.");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            logger.info("Track skipped.");
        }
    }

    public void previous() {
        synchronized (lock) {
            logger.info("Returned to previous track.");
        }
    }
}
