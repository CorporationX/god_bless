package school.faang.sprint_3.task_49288;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock;
    private boolean isPlaying;

    public Player() {
        isPlaying = false;
        lock = new Object();
    }

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                log.info("Track is playing. {}", Thread.currentThread().getName());
            } else {
                log.info("The track is already playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("Track paused. {}", Thread.currentThread().getName());
            } else {
                log.info("The track is already paused");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("Next track. {}", Thread.currentThread().getName());
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("Previous track. {}", Thread.currentThread().getName());
        }
    }
}
