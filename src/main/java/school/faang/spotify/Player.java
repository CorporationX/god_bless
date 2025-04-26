package school.faang.spotify;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                log.info("Музыка воспроизводится");
            } else {
                log.info("Музыка уже играет");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("Трек поставлен на паузу");
            } else {
                log.info("Трек уже стоит на паузе");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("Трек пропущен");
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("Вернулись к предыдущему треку");
        }
    }
}