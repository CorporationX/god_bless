package BJS2_61969;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                log.info("Already playing");
            } else {
                isPlaying = true;
                log.info("Playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("Paused");
            } else {
                log.info("Already paused");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("Skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("Previous");
        }
    }
}
