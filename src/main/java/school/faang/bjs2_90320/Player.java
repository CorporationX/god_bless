package school.faang.bjs2_90320;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                log.info("Music is playing - {}", isPlaying);
            } else {
                log.info("Music is already play - {}", isPlaying);
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("Music is pause - {}", isPlaying);
            } else {
                log.info("Music is already pause - {}", isPlaying);
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("Next song - {}", isPlaying);
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("Previous song - {}", isPlaying);
        }
    }
}