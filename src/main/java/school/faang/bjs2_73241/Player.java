package school.faang.bjs2_73241;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                log.info("The track started playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("The track was paused");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
            }
            log.info("The track was skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
            }
            log.info("Was turned to previous track");
        }
    }
}
