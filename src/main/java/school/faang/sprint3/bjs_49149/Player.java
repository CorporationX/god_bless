package school.faang.sprint3.bjs_49149;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private boolean isPlaying;
    private final Object lock = new Object();

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                log.info("Started playing");
            } else {
                log.info("Music is already playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("Track is paused");
            } else {
                log.info("It's already on pause");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("Next track");
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("Previous track");
        }
    }
}
