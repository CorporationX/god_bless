package school.faang.bjs2_90553;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {

    private boolean isPlaying = false;
    private final Object lock = new Object();

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
                log.info("Music paused");
            } else {
                log.info("Music has already paused");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("Track has been skipped");
        }

    }

    public void previous() {
        synchronized (lock) {
            log.info("Track has been returned");
        }
    }
}
