package school.faang.bjs2_90252;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = true;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                log.info("Начал воспроизведение трека");
            } else {
                log.info("Трек уже играет!");
            }

        }
    }

    public void stop() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("Остановил трек");
            } else {
                log.info("Трек уже на паузе!");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("Пропустил трек");
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("Возвращается к предыдущему треку");
        }
    }
}
