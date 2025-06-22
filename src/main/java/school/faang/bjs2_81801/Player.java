package school.faang.bjs2_81801;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Player {

    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                try {
                    isPlaying = true;
                    Thread.sleep(1000);
                    log.info("Music is play");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                try {
                    Thread.sleep(1000);
                    log.info("Music is paused");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void skip() {
        log.info("Play is next track");
    }

    public void previous() {
        log.info("Play is previous track");
    }
}
