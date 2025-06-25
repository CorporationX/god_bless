package school.faang.bjs281813;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    @Getter
    private final Object lock = new Object();
    private boolean isPlaying = false;
    private int trackIndex = 1;

    public String getCurrentTrack() {
        return "Track " + trackIndex;
    }

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                log.info("[{}] ▶️ Музыка включена - {}", Thread.currentThread().getName(), getCurrentTrack());
            } else {
                log.info("[{}] ▶️ Музыка уже играет - {}", Thread.currentThread().getName(), getCurrentTrack());
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("[{}] ⏸️ Музыка на паузе - {}", Thread.currentThread().getName(), getCurrentTrack());
            } else {
                log.info("[{}] ⏸️ Музыка уже на паузе - {}", Thread.currentThread().getName(), getCurrentTrack());
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            trackIndex++;
            isPlaying = true;
            log.info("[{}] ⏭️ Переход к следующему треку: {}", Thread.currentThread().getName(), getCurrentTrack());
        }
    }

    public void previous() {
        synchronized (lock) {
            if (trackIndex > 1) {
                trackIndex--;
            }
            isPlaying = true;
            log.info("[{}] ⏮️ Переход к предыдущему треку: {}", Thread.currentThread().getName(), getCurrentTrack());
        }
    }
}