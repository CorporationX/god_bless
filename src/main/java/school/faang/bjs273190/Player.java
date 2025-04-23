package school.faang.bjs273190;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                log.info("Music is playing already");
            } else {
                isPlaying = true;
                log.info("Starting playing music");
            }
        }
    }
    
    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("Music is stopped");
            } else {
                log.info("Music not playing");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("Music is skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("Previous music is started");
        }
    }
}
