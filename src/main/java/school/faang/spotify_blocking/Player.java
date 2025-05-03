package school.faang.spotify_blocking;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                log.info("Музыка уже играет. ");
                return;
            }
            isPlaying = true;
            log.info("Начинаем воспроизведение музыкиЖ. ");
        }
    }

    public void pause() {
        synchronized (lock) {
            if (!isPlaying) {
                log.info("Музыка не играет.");
                return;
            }
            isPlaying = false;
            log.info("Ставим музыку на паузу.");
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("Пропускаем трек.");
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("Возвращаемся к предыдущему треку.");
        }
    }
}