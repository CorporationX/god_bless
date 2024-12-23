package school.faang.bjs249550;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                log.info("Music is already playing");
                return;
            }
            isPlaying = true;
            log.info("Music is playing");
        }
    }

    public void pause() {
        synchronized (lock) {
            if (checkPlayingMusic()) {
                return;
            }
            isPlaying = false;
            log.info("Music is paused");
        }
    }

    public void skip() {
        synchronized (lock) {
            if (checkPlayingMusic()) {
                return;
            }
            log.info("Music is skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            if (checkPlayingMusic()) {
                return;
            }
            log.info("Music is previous");
        }
    }

    private boolean checkPlayingMusic() {
        if (!isPlaying) {
            log.info("Music is not playing");
            return true;
        }
        return false;
    }
}
