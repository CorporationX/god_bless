package school.faang.spotify;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final String lock;
    private boolean isPlaying;

    public Player(String lock) {
        this.lock = lock;
        this.isPlaying = false;
    }

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                log.info("Музыка играет");
            } else {
                log.info("Музыка уже играет");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("Музыка на паузе");
            } else {
                log.info("Музыка и так на парузе");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("Трек скинпнули");
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("Включить предыдущий трек");
        }
    }
}
