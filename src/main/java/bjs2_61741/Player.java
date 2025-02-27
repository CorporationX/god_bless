package bjs2_61741;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object locker = new Object();
    private boolean isPlaying = false;
    private final int trackCount;
    private int trackNumber = 0;

    public Player(int trackCount) {
        this.trackCount = trackCount;

        log.info("Создан список воспроизведения. Всего треков: {}", this.trackCount);
    }

    public boolean play() {
        if (isPlaying) {
            log.info("Трек #{}: уже воспроизводится", trackNumber);

            return false;
        }

        synchronized (locker) {
            if (isPlaying) {
                log.info("Трек #{}: уже воспроизводится", trackNumber);

                return false;
            }

            isPlaying = true;

            log.info("Трек #{}: воспроизведение", trackNumber);
        }

        return true;
    }

    public boolean pause() {
        if (!isPlaying) {
            log.info("Трек #{}: уже на паузе", trackNumber);

            return false;
        }

        synchronized (locker) {
            if (!isPlaying) {
                log.info("Трек #{}: уже на паузе", trackNumber);

                return false;
            }

            isPlaying = false;

            log.info("Трек #{}: пауза", trackNumber);
        }

        return true;
    }

    public void skip() {
        synchronized (locker) {
            var currentTrackNumber = trackNumber;
            trackNumber = (trackNumber + 1) % trackCount;
            isPlaying = true;

            log.info("Трек #{}: пропуск", currentTrackNumber);
        }
    }

    public void previous() {
        synchronized (locker) {
            trackNumber = (trackNumber - 1 + trackCount) % trackCount;

            log.info("Трек #{}: переход на него", trackNumber);
        }
    }
}
