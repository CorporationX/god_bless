package school.faang.synchronization.bjs2_73121;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                log.info("Музыка воспроизводится. isPlaying: {}", isPlaying);
            } else {
                log.info("Музыка уже играет.");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("paused. isPlaying: {}", isPlaying);
            } else {
                log.info("Музыка уже на паузе.");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = true;
            log.info("song skipped. isPlaying: {}", isPlaying);
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("previous song. isPlaying: {}", isPlaying);
        }
    }
}
