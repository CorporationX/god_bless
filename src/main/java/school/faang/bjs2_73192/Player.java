package school.faang.bjs2_73192;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {

    private static final Object LOCK = new Object();
    private static boolean isPlaying = false;

    public void play() {
        synchronized (LOCK) {
            if (isPlaying) {
                log.info("Thread -> {} in Player.play(), music is already playing",
                        Thread.currentThread().getId());
                try {
                    LOCK.wait(3000);
                    play();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            log.info("Thread -> {} in Player.play(), isPlaying -> {} | BEFORE",
                    Thread.currentThread().getId(), isPlaying);
            isPlaying = true;
            log.info("Thread -> {} in Player.play(), isPlaying -> {} | AFTER",
                    Thread.currentThread().getId(), isPlaying);
        }
    }

    public void pause() {
        synchronized (LOCK) {
            if (!isPlaying) {
                log.info("Thread -> {} in Player.pause(), music is already on pause",
                        Thread.currentThread().getId());
                try {
                    LOCK.wait(3000);
                    pause();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            log.info("Thread -> {} in Player.pause(), isPlaying -> {} | BEFORE",
                    Thread.currentThread().getId(), isPlaying);
            isPlaying = false;
            log.info("Thread -> {} in Player.pause(), isPlaying -> {} | AFTER",
                    Thread.currentThread().getId(), isPlaying);
        }
    }

    public void skip() {
        synchronized (LOCK) {
            log.info("Thread -> {} in Player.skip(), isPlaying -> {} | BEFORE",
                    Thread.currentThread().getId(), isPlaying);
            isPlaying = false;
            play();
            log.info("Thread -> {} in Player.skip(), isPlaying -> {} | AFTER",
                    Thread.currentThread().getId(), isPlaying);
        }
    }

    public void previous() {
        synchronized (LOCK) {
            log.info("Thread -> {} in Player.previous(), isPlaying -> {} | BEFORE",
                    Thread.currentThread().getId(), isPlaying);
            isPlaying = false;
            play();
            log.info("Thread -> {} in Player.previous(), isPlaying -> {} | AFTER",
                    Thread.currentThread().getId(), isPlaying);
        }
    }
}
