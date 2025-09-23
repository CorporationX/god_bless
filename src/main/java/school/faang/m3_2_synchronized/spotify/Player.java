package school.faang.m3_2_synchronized.spotify;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            log.info("Начато воспроизведение музыки: {}", isPlaying);
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            log.info("Пауза: {}", isPlaying);
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
