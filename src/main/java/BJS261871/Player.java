package BJS261871;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            log.info("Thread from play");
            log.info(isPlaying ? "Playing" : "Stopped");
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            log.info("Thread from pause ");
            log.info(isPlaying ? "Playing" : "Stopped");
        }
    }

    public void skip() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
            }
            log.info("Thread from skip ");
            log.info(isPlaying ? "Playing" : "Stopped");
        }
    }

    public void previous() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
            }
            log.info("Thread from previous ");
            log.info(isPlaying ? "Playing" : "Stopped");
        }
    }

}
