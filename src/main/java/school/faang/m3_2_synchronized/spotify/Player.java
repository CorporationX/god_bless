package school.faang.m3_2_synchronized.spotify;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                log.info("Музыка воспроизводится.");
            } else {
                log.info("Музыка уже играет.");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("Музыка поставлена на паузу.");
            } else {
                log.info("Музыка уже на паузе.");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("Пропуск трека");
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("вернуться к предыдущему треку");
        }
    }
}
