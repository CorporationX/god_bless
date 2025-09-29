package school.faang.bjs2_90442;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private boolean isPlaying;
    private int currentTrack = 1;
    private final int totalTracks = 5;
    private final Object lock = new Object();

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                log.info("Уже играет трек. Текущий трек: {}", currentTrack);
            } else {
                isPlaying = true;
                log.info("Старт воспроизведения. Сейчас играет трек: {}", currentTrack);
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.warn("Поставил на паузу. Текущий трек: {}", currentTrack);
            } else {
                log.info("Музыка уже на паузе. Текущий трек: {}", currentTrack);
            }
        }
    }

    private int nextTrack() {
        return (currentTrack % totalTracks) + 1;
    }

    private int previousTrack() {
        return (currentTrack - 2 + totalTracks) % totalTracks + 1;
    }

    public void skip() {
        synchronized (lock) {
            currentTrack = nextTrack();
            log.info("Пропуск. Текущий трек: {}", currentTrack);
        }
    }

    public void previous() {
        synchronized (lock) {
            currentTrack = previousTrack();
            log.info("Назад. Текущий трек: {}", currentTrack);
        }
    }
}