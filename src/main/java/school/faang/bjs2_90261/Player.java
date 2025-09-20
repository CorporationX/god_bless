package school.faang.bjs2_90261;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                logWithThread("Трек уже играет");
            } else {
                isPlaying = true;
                logWithThread("Трек воспроизводится");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                logWithThread("Трек поставлен на паузу");
            } else {
                logWithThread("Трек уже на паузе");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            logWithThread("Пропущен трек");
        }
    }

    public void previous() {
        synchronized (lock) {
            logWithThread("Включен предыдущий трек");
        }
    }

    private void logWithThread(String message) {
        log.info("{} [{}]", message, Thread.currentThread().getName());
    }
}
