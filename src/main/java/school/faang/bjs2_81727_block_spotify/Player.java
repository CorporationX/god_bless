package school.faang.bjs2_81727_block_spotify;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                log.info("Music is playing.");
            } else {
                log.info("Music already playing.");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("Music is paused.");
            } else {
                log.info("Music already paused.");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = false;
            log.info("Switching to the next track.");
            isPlaying = true;
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = false;
            log.info("Switching to the previous track.");
            isPlaying = true;
        }
    }
}