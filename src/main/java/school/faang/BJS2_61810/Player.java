package school.faang.BJS2_61810;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                log.info(PlayerMessage.MUSIC_ALREADY_PLAYING);
            } else {
                isPlaying = true;
                log.info(PlayerMessage.MUSIC_PLAYING);
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (!isPlaying) {
                log.info(PlayerMessage.MUSIC_ALREADY_PAUSED);
            } else {
                isPlaying = false;
                log.info(PlayerMessage.MUSIC_PAUSED);
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info(PlayerMessage.MUSIC_SKIP);
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info(PlayerMessage.MUSIC_PREVIOUS);
        }
    }
}
