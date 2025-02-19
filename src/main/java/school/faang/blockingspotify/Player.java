package school.faang.blockingspotify;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = true;
                log.info("{} запускает воспроизведение",
                        Thread.currentThread().getName());
            } else {
                log.info("{} музыка уже воспроизводится",
                        Thread.currentThread().getName());
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("{} ставит музыку на паузу",
                        Thread.currentThread().getName());
            } else {
                log.info("{} музыка уже на паузе",
                        Thread.currentThread().getName());
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("{} пропускает трек",
                    Thread.currentThread().getName());
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("{} возвращается к предыдущему треку",
                    Thread.currentThread().getName());
        }
    }
}
