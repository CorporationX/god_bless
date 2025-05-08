package school.faang.spotify;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                log.info("Start playing");
            } else {
                log.info("Music is already playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("Stop playing");
            } else {
                log.info("Music is already stopped");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("Song skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("Going to previous song");
        }
    }
}
