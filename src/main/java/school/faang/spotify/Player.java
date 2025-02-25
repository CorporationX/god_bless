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
                log.info("The music started playing");
            } else {
                log.info("The music is already playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("The music is stopped");
            } else {
                log.info("The music is not playing now");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("The music is skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("Previous music is started");
        }
    }
}
