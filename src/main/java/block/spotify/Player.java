package block.spotify;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                log.info("The music started playing...");
            } else {
                log.info("Music has already been launched!");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("The music is paused...");
            } else {
                log.info("Music has already been paused!");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("The track is skipped!");
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("Returned to previous track!");
        }
    }
}
