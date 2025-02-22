package school.faang.bjs2_61728;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private boolean isPlaying;
    private final Object lock = new Object();

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                log.info("Already playing");
                return;
            }
            isPlaying = true;
            log.info("Playing");
        }
    }

    public void pause() {
        synchronized (lock) {
            if (!isPlaying) {
                log.info("Already paused");
                return;
            }
            isPlaying = false;
            log.info("Paused");
        }
    }

    public void skip() throws InterruptedException {
        synchronized (lock) {
            isPlaying = false;
            log.info("Skipping to the next track...");
        }
        Thread.sleep(500);
        synchronized (lock) {
            isPlaying = true;
            log.info("The next track is playing");
        }
    }

    public void previous() throws InterruptedException {
        synchronized (lock) {
            isPlaying = false;
            log.info("Let's move on to the previous track...");
        }
        Thread.sleep(500);
        synchronized (lock) {
            isPlaying = true;
            log.info("The previous track is playing");
        }
    }
}