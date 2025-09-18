package school.faang.bjs2_90227;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                log.info("music is playing");
            } else {
                log.info("the music is already playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("the music is paused");
            } else {
                log.info("the music is already paused");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("Music skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("Previous music is on");
        }
    }
}
