package school.faang.bjs2_73137;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (this.lock) {
            if (this.isPlaying) {
                log.info("action PLAY: player is playing");
            } else {
                this.isPlaying = true;
                log.info("action PLAY: player start play");
            }
        }
    }

    public void pause() {
        synchronized (this.lock) {
            if (this.isPlaying) {
                this.isPlaying = false;
                log.info("action PAUSE: player stop play");
            } else {
                log.info("action PAUSE: player don't play");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("action SKIP: player go to the next song");
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("action PREVIOUS: player back to the previous song");
        }
    }
}
