package school.faang.spotify;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Danil Pudovkin
 * @since 17.06.2025
 */
@Slf4j
public class Player {

    private final Object lock = new Object();
    @Getter
    private boolean isPlaying = false;

    public void play() {
        if (!isPlaying) {
            synchronized (lock) {
                isPlaying = true;
                log.info("Плеер включен");
            }
        } else {
            log.info("Плеер уже включен");
        }
    }

    public void pause() {
        if (isPlaying) {
            synchronized (lock) {
                isPlaying = false;
                log.info("Плеер поставлен на паузу");
            }
        } else {
            log.info("Плеер уже поставлен на паузу");
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("Следующая песня");
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("Предыдущая песня");
        }
    }
}
