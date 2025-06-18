package school.faang.bjs2_81720;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                log.info("Музыка уже воспроизводится");
            } else {
                log.info("Начато воспроизведение трека");
                isPlaying = true;
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                log.info("Остановлено воспроизведение трека");
                isPlaying = false;
            } else {
                log.info("Музыка уже остановлена");
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
            log.info("К предыдущему треку");
        }
    }
}
