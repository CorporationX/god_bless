package school.faang.bjs2_63700;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = true;

    public void play() {
        synchronized (lock) {
            log.info(!isPlaying ? "Музыка воспроизводится." : "Музыка уже играет.");
            if (!isPlaying) {
                isPlaying = true;
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            log.info(isPlaying ? "Музыка поставлена на паузу." : "Музыка уже на паузе.");
            if (isPlaying) {
                isPlaying = false;
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
