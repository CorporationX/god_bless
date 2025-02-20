package school.faang.sprint.third.spotify;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Data
@Slf4j
public class Player {
    private Random rand = new Random();
    public boolean isPlaying;

    public void play() {
        synchronized (this) {
            isPlaying = true;
            log.info("Player is playing");
            try {
                Thread.sleep(rand.nextInt(7000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            isPlaying = false;
            this.notifyAll();
        }
    }

    public void pause() {
        synchronized (this) {
            isPlaying = false;
            this.notifyAll();
            log.info("Play is paused");
        }

    }

    public void skip() {
        synchronized (this) {
            if (isPlaying) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        log.info("Playing next track");
    }

    public void previous() {
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        log.info("Playing previous track");
    }
}
