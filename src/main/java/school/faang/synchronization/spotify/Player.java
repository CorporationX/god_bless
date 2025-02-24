package school.faang.synchronization.spotify;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class Player {
    private final Object lock = new Object();

    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            log.info("Player is playing");
            setPlaying(true);
        }
    }

    public void pause() {
        synchronized (lock) {
            log.info("Player paused");
            setPlaying(false);
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("Player skipped");
            setPlaying(false);
        }
        play();
    }

    public void previous() {
        synchronized (lock) {
            log.info("Player plays previous song");
            setPlaying(false);
        }
        play();
    }
}
