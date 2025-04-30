package school.faang.bjs2_73377;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                log.info("The player is already running...");
            } else {
                isPlaying = true;
                log.info("Play ");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("Pause");
            } else {
                log.info("The player is already paused");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("Skip track");
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("Previous track");
        }
    }
}
