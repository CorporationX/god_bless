package school.faang.spotify;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                log.info("{}: Playback started.", Thread.currentThread().getName());
            } else {
                log.info("{}: Already playing.", Thread.currentThread().getName());
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("{}: Music paused.", Thread.currentThread().getName());
            } else {
                log.info("{}: Already paused.", Thread.currentThread().getName());
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("{}: Skipped current track.", Thread.currentThread().getName());
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("{}: Returned to previous track.", Thread.currentThread().getName());
        }
    }
}
