package school.faang.spotify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Player {

    private static final Logger LOGGER = LoggerFactory.getLogger(Player.class);
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                LOGGER.info("Включил музыку! Танцуем!");
            } else {
                LOGGER.info("Музыка уже воспроизводится");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                LOGGER.info("Остановил воспроизведение");
            } else {
                LOGGER.info("Музыка уже на паузе");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            LOGGER.info("Запускаю следующий трек");
        }
    }

    public void previous() {
        synchronized (lock) {
            LOGGER.info("Запускаю предыдущий трек");
        }
    }
}
