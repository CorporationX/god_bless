package school.faang.task_61798;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Player {
    private static final Logger LOG = LoggerFactory.getLogger(Player.class);
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                LOG.info("Music is playing");
            } else {
                LOG.info("Music is already playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                LOG.info("The music is stopped");
            } else {
                LOG.info("The music has already stopped");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            LOG.info("Track skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            LOG.info("Went back to the previous track");
        }
    }
}
