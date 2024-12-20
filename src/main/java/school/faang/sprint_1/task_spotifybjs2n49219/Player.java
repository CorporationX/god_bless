package school.faang.sprint_1.task_spotifybjs2n49219;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock;
    private boolean isPlaying;

    public Player() {
        this.lock = new Object();
        this.isPlaying = false;
    }

    public synchronized void play() {
        synchronized (lock) {
            if (isPlaying) {
                log.info("music already Playing ..... |>");
            } else {
                log.info("Play pressed");
                isPlaying = true;
            }
        }
    }

    public synchronized void pause() {
        synchronized (lock) {
            log.info("Pause pressed ");
            isPlaying = false;
        }
    }

    public synchronized void skip() {
        synchronized (lock) {
            log.info("Skip pressed");
        }
    }

    public synchronized void previous() {
        synchronized (lock) {
            log.info("Previous pressed");
        }
    }
}
