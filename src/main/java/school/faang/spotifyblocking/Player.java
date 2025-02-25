package school.faang.spotifyblocking;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@Data
public class Player {
    private final ReentrantLock lock = new ReentrantLock();
    private AtomicBoolean isPlaying = new AtomicBoolean(false);

    public void play() {
        synchronized (lock) {
            lock.lock();
            if (isPlaying.get()) {
                log.info("Поток {} сообщает, что композиция уже воспроизводится", Thread.currentThread().getName());
            } else {
                isPlaying.set(true);
                log.info("Поток {} включил плеер", Thread.currentThread().getName());
            }
            lock.unlock();
        }
    }

    public void pause() {
        synchronized (lock) {
            lock.lock();
            if (isPlaying.get()) {
                isPlaying.set(false);
                log.info("Поток {} остановил композицию", Thread.currentThread().getName());
            } else {
                log.info("Поток {} сообщает, что композиция уже на паузе", Thread.currentThread().getName());
            }
            lock.unlock();
        }
    }

    public void skip() {
        synchronized (lock) {
            lock.lock();
            log.info("Поток {} пропустил композицию", Thread.currentThread().getName());
            lock.unlock();
        }
    }

    public void previous() {
        synchronized (lock) {
            lock.lock();
            log.info("Поток {} вернулся к предыдущему треку", Thread.currentThread().getName());
            lock.unlock();
        }
    }
}