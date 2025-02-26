package school.faang.blocking_spotify.BJS2_61770;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Player {
    private static final Logger log = LoggerFactory.getLogger(Player.class);

    private final Object lock = new Object();

    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                log.info("Playing");
            } else {
                log.info("the music's already playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("Paused");
            } else {
                log.info("the music is already on pause");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("skip track");
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("previous track");
        }
    }
}
