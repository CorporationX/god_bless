package school.faang.spotify;

import lombok.Getter;

import java.util.logging.Logger;

public class Player {
    private static final Logger logger = Logger.getLogger(Player.class.getName());
    private final Object lock = new Object();

    @Getter
    private volatile boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                logger.info("The music is playing.");
            } else {
                logger.info("The music is already playing.");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                logger.info("The music is paused.");
            } else {
                logger.info("The music is already on pause.");
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
            logger.info("Went back to the previous track.");
        }
    }
}
