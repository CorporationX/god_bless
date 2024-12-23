package school.faang.bjs_49249;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        if (isPlaying) {
            log.info("Player is already playing");
        } else {
            synchronized (lock) {
                isPlaying = true;
            }
            log.info("play");
        }
    }

    public void pause() {
        if (isPlaying) {
            synchronized (lock) {
                isPlaying = false;
            }
            log.info("pause");
        } else {
            log.info("Player is not playing");
        }
    }

    public void skip() {
        log.info("skip");
    }

    public void previous() {
        log.info("previous");
    }
}
