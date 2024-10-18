package school.faang.spotify;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {

    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                log.info("Music is already playing");
            } else {
                isPlaying = true;
                log.info("Music is playing");
            }
        }
    }

    public void stop() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("Music is stopped");
            } else {
                log.info("Music is already stopped");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("Music is skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("Music is switched to previous");
        }
    }
}
