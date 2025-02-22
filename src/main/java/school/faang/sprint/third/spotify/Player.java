package school.faang.sprint.third.spotify;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Data
@Slf4j
public class Player {
    private static final int MAX_TIMEOUT = 7000;
    private final Random rand = new Random();
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            log.info("Player is playing");
            try {
                Thread.sleep(rand.nextInt(MAX_TIMEOUT));
            } catch (InterruptedException e) {
                log.error("Thread interrupted {}", e.getMessage());
                Thread.currentThread().interrupt();
            }
            isPlaying = false;
            this.notifyAll();
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            this.notifyAll();
            log.info("Play is paused");
        }

    }

    public void skip() {
        synchronized (this) {
            if (isPlaying) {
                try {
                    while (isPlaying) {
                        this.wait();
                    }
                } catch (InterruptedException e) {
                    log.error("Thread interrupted {}", e.getMessage());
                    Thread.currentThread().interrupt();
                }
            }
        }
        log.info("Playing next track");
    }

    public void previous() {
        synchronized (lock) {
            if (isPlaying) {
                try {
                    while (isPlaying) {
                        this.wait();
                    }
                } catch (InterruptedException e) {
                    log.error("Thread interrupted {}", e.getMessage());
                    Thread.currentThread().interrupt();
                }
            }
        }
        log.info("Playing previous track");
    }
}
