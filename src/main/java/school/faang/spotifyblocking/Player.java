package school.faang.spotifyblocking;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                log.info("Поток {} сообщает, что композиция уже воспроизводится", Thread.currentThread().getName());
            } else {
                this.setPlaying(true);
                log.info("Поток {} включил плеер", Thread.currentThread().getName());
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                this.setPlaying(false);
                log.info("Поток {} остановил композицию", Thread.currentThread().getName());
            } else {
                log.info("Поток {} сообщает, что композиция уже на паузе", Thread.currentThread().getName());
            }

        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("Поток {} пропустил композицию", Thread.currentThread().getName());
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("Поток {} вернулся к предыдущему треку", Thread.currentThread().getName());
        }
    }
}