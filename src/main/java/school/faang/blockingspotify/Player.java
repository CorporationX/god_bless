package school.faang.blockingspotify;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private static final Object LOCK = new Object();
    private static final long MAX_TIME_EXECUTION = 3000;
    private static final long MIN_TIME_EXECUTION = 1000;

    private boolean isPlaying = false;

    public void play() throws InterruptedException {
        synchronized (LOCK) {
            if (isPlaying) {
                LOCK.wait();
            }
            simulateDelay();
            isPlaying = true;
            log.info("Music playing");
            LOCK.notify();
        }
    }

    public void pause() throws InterruptedException {
        synchronized (LOCK) {
            if (!isPlaying) {
                LOCK.wait();
            }
            simulateDelay();
            isPlaying = false;
            log.info("Music paused");
            LOCK.notify();
        }
    }

    public void skip() throws InterruptedException {
        synchronized (LOCK) {
            simulateDelay();
            log.info("Next music");
        }
    }

    public void previous() throws InterruptedException {
        synchronized (LOCK) {
            simulateDelay();
            log.info("Previous music");
        }
    }

    private void simulateDelay() throws InterruptedException {
        Thread.sleep((long) (Math.random() * MAX_TIME_EXECUTION + MIN_TIME_EXECUTION));
    }
}
