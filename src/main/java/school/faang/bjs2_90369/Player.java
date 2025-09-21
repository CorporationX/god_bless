package school.faang.bjs2_90369;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;
    private int currentTrack = 1;
    private final int totalTracks = 10;

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
            log.info("Трек пропущен.");
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("Вернулись к предыдущему треку.");
        }
    }
}
