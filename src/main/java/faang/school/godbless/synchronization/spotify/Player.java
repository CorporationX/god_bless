package faang.school.godbless.synchronization.spotify;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            log.info("Start playing. Player was playing: " + isPlaying);
            isPlaying = true;
            log.info("Player is playing.");
        }
    }

    public void pause() {
        synchronized (lock) {
            log.info("Stop playing. Player was playing: " + isPlaying);
            isPlaying = false;
            log.info("Player isn't playing.");
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("Skipping song. Player was playing: " + isPlaying);
            isPlaying = true;
            log.info("Player is playing.");
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("Playing previous song. Player was playing: " + isPlaying);
            isPlaying = true;
            log.info("Player is playing.");
        }
    }

    public boolean isPlaying() {
        return isPlaying;
    }
}
