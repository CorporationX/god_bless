package school.faang.bjs2_90271;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;
    private int currentTrack = 0;
    private final int totalTracks = 5;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                log.info("нажал play: Воспроизведение трека {}", currentTrack);
            } else {
                log.info("нажал play: Уже играет");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("нажал pause: Пауза на треке {}", currentTrack);
            } else {
                log.info("нажал pause: Уже на паузе");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            currentTrack = (currentTrack + 1) % totalTracks;
            log.info("нажал skip: Пропустил трек {}", currentTrack);
        }
    }

    public void previous() {
        synchronized (lock) {
            currentTrack = (currentTrack - 1 + totalTracks) % totalTracks;
            log.info("нажал previous: Вернулся к треку {}", currentTrack);
        }
    }
}