package school.faang.sprint3.task49300;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {

    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                log.info("Music playing now");
                isPlaying = true;
            } else {
                log.info("Music already playing now");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                log.info("Music on pause");
                isPlaying = false;
            } else {
                log.info("Music already on pause");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("Music skipped to next track");
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("Music rewind to previous track");
        }
    }
}
