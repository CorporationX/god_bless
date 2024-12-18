package school.faang.task_49159;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock;
    private boolean isPlaying;

    public Player() {
        this.lock = new Object();
        this.isPlaying = false;
    }

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                log.info("Музыка воспроизводится.");
            } else {
                log.warn("Музыка уже играет.");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("Музыка поставлена на паузу.");
            } else {
                log.warn("Музыка уже на паузе.");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("Трек пропущен.");
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("Вернулись к предыдущему треку.");
        }
    }

}
