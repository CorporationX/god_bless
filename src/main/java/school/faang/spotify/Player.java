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
        synchronized (lock) {
            isPlaying = true;
            log.info("Включено проигрывание музыки");
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            log.info("Плеер поставлен на паузу");
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
