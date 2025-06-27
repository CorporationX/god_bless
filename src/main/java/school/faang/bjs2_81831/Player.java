package school.faang.bjs2_81831;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                log.info("{} is resuming...", Thread.currentThread().getName());
            } else {
                log.info("Music is already playing...");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("{} is pausing...", Thread.currentThread().getName());
            } else {
                log.info("Music is already paused...");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("{} is switching to the next track...", Thread.currentThread().getName());
            isPlaying = true;
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("{} is switching to the previous track...", Thread.currentThread().getName());
            isPlaying = true;
        }
    }
}
