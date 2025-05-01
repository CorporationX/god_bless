package school.faang.bjs2_73272;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();

    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                log.info("Music is already playing...");
            } else {
                isPlaying = true;
                log.info("Music was started to play");
            }
        }

    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("Pause playing music");
            } else {
                log.info("Music is already on pause");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("Track was skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("Returning to previous track");
        }
    }
}