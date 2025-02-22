package school.faang.spotify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Player {
    private final Object lock = new Object();
    boolean isPlaying;
    private static final Logger logger = LoggerFactory.getLogger(Player.class);


    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                logger.info("Start playing music");
                isPlaying = true;
            } else {
                logger.info("Music is already playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                logger.info("Pause playing music");
                isPlaying = false;
            } else {
                logger.info("Music is already paused");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            logger.info("Skip the track");
        }
    }

    public void previous() {
        synchronized (lock) {
            logger.info("Playing previous track");
        }
    }



}
