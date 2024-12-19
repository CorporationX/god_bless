package school.faang.spotify_blockers;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                log.info("Music already playing");
            } else {
                log.info("Music start playing");
                isPlaying = true;
            }
        }
    }

    public void stop() {
        synchronized (lock) {
            if (isPlaying) {
                log.info("Music playing stopped");
                isPlaying = false;
            } else {
                log.info("Music already stopped");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("Track skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("Return to previous track");
        }
    }
}
