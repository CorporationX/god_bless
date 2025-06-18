package school.faang.bjs2_81742;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                log.info("Music is playing");
            } else {
                log.info("Music is already playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("Music is paused");
            } else {
                log.info("Music is already paused");
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
            log.info("Music is set to previous track");
        }
    }
}
