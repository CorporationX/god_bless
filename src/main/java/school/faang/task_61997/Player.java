package school.faang.task_61997;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false; // Tracks playback state

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                log.info("Play command ignored. Already playing. [Thread: {}]", Thread.currentThread().getId());
                return;
            }
            isPlaying = true;
            log.info("Playing... [Thread: {}]", Thread.currentThread().getId());
        }
    }

    public void pause() {
        synchronized (lock) {
            if (!isPlaying) {
                log.info("Pause command ignored. Already paused. [Thread: {}]", Thread.currentThread().getId());
                return;
            }
            isPlaying = false;
            log.info("Paused... [Thread: {}]", Thread.currentThread().getId());
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("Skipped to the next track. [Thread: {}]", Thread.currentThread().getId());
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("Returned to the previous track. [Thread: {}]", Thread.currentThread().getId());
        }
    }
}