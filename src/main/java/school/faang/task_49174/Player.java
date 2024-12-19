package school.faang.task_49174;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private static final int THREAD_DELAY = 1000;

    private boolean isPlaying;

    public synchronized void play() {
        isPlaying = true;
        log.info("Player is playing. Is playing: {}", isPlaying);
    }

    public synchronized void pause() {
        isPlaying = false;
        log.info("Player on pause. Is playing: {}", isPlaying);
    }

    public synchronized void skip() {
        pause();
        log.info("Player is skipping... Is playing: {}", isPlaying);
        try {
            Thread.sleep(THREAD_DELAY);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        play();
    }

    public synchronized void previous() {
        pause();
        log.info("Player returns to the previous one... Is playing: {}", isPlaying);
        try {
            Thread.sleep(THREAD_DELAY);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        play();
    }
}
