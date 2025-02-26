package school.faang.task61987;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    public boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
            }
            log.info("Play");
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
            }
            log.info("Pause");
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("Skip");
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("Previous");
        }
    }
}
