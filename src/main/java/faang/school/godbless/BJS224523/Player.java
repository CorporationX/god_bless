package faang.school.godbless.BJS224523;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            log.info("{} started playing.", Thread.currentThread().getName());
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            log.info("{} paused the player.", Thread.currentThread().getName());
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = true;
            log.info("{} skipped to the next track.", Thread.currentThread().getName());
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = true;
            log.info("{} went to the previous track.", Thread.currentThread().getName());
        }
    }
}
