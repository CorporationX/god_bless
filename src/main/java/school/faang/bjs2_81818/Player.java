package school.faang.bjs2_81818;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {

    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                log.info("Playing music...");
            } else {
                log.info("Already playing.");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("Music paused.");
            } else {
                log.info("Music already paused.");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            if (isPlaying) {
                log.info("Skipping to next track...");
            } else {
                log.info("Can't skip — music is paused.");
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            if (isPlaying) {
                log.info("Going to previous track...");
            } else {
                log.info("Can't go back — music is paused.");
            }
        }
    }
}
