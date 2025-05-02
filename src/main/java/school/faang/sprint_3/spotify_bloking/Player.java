package school.faang.sprint_3.spotify_bloking;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                log.info("Playing started");
            } else {
                log.info("Playing already started");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
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
