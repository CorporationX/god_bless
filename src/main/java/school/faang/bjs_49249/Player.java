package school.faang.bjs_49249;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            log.info("play");
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            log.info("pause");
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = true;
            log.info("skip");
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = true;
            log.info("previous");
        }
    }
}
