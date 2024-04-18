package faang.school.godbless.spotify_blocking;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock;
    private boolean isPlaying;

    public Player() {
        this.lock = new Object();
        this.isPlaying = false;
    }

    public boolean isPlaying() {
        synchronized (lock) {
            return isPlaying;
        }
    }

    public void setPlaying(boolean playing) {
        synchronized (lock) {
            isPlaying = playing;
        }
    }

    public void play() {
        log.info("Called by play method");
        setPlaying(true);
    }

    public void pause() {
        log.info("Called by pause method");
        setPlaying(false);
    }

    public void skip() {
        log.info("Called by skip method");
        setPlaying(false);
    }

    public void previous() {
        log.info("Called by previous method");
        setPlaying(false);
    }
}