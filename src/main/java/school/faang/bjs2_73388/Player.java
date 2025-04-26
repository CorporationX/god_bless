package school.faang.bjs2_73388;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private boolean isPlaying = false;
    private final Lock lock = new ReentrantLock();
    private final long waitTime = 3_000;

    public void ifPlaying() {
        if (isPlaying) {
            log.info("The song is now playing.");
        } else {
            log.info("The song is not playing.");
        }
    }

    public void play() {
        synchronized (lock) {
            log.info("The lock is set with thread {}.", Thread.currentThread().getName());
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            isPlaying = true;
            ifPlaying();
        }
    }

    public void pause() {
        if (lock.tryLock()) {
            log.info("The lock is set with thread {}.", Thread.currentThread().getName());
            isPlaying = false;
            lock.unlock();
            ifPlaying();
        } else {
            log.info("The system is used by the thread {}.", Thread.currentThread().getName());
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("The lock is set with thread {}. Switching to a next song.", Thread.currentThread().getName());
        }
    }

    public void prevoius() {
        synchronized (lock) {
            log.info("The lock is set with thread {}. Switching to a prev song.", Thread.currentThread().getName());
        }
    }
}
