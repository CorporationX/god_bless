package bjs2_73201;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                log.info("Music playback has started");
            } else {
                log.info("The music is already playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("Music playback has paused");
            } else {
                log.info("The music is not playing");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("You skipped the current track");
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("Have you returned to the previous track");
        }
    }
}
