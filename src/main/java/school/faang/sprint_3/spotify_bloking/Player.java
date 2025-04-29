package school.faang.sprint_3.spotify_bloking;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = Boolean.FALSE;

    public void play() {
        synchronized (lock) {
            if (isPlaying == Boolean.FALSE) {
                isPlaying = Boolean.TRUE;
                log.info("Playing started");
            } else {
                log.info("Playing already started");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying == Boolean.TRUE) {
                isPlaying = Boolean.FALSE;
                log.info("Playing stopped");
            } else {
                log.info("Playing already stopped");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = Boolean.TRUE;
            log.info("Playing next track");
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = Boolean.TRUE;
            log.info("Playing previous track");
        }
    }
}
