package school.faang.bjs249451;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            try {
                if (!isPlaying) {
                    isPlaying = true;
                    log.info("Music started playing");
                } else {
                    log.info("Music is already playing");
                }
            } catch (Exception e) {
                log.error("An error occurred in the play method", e);
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            try {
                if (isPlaying) {
                    isPlaying = false;
                    log.info("Music on a pause");
                } else {
                    log.info("Music is already on a pause ");
                }
            } catch (Exception e) {
                log.error("An error occurred in te pause method");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            try {
                log.info("Track skipped.");
            } catch (Exception e) {
                log.error("An error occurred in te skip method");
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            try {
                log.info("Return to previous track");
            } catch (Exception e) {
                log.error("An error occurred in te previous method");
            }
        }
    }
}
