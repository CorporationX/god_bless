package school.faang.bjs2_37367;

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
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("Music is paused");
            } else {
                log.info("Music is already in pause");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("Track is skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("Back to previous track");
        }
    }
}
