package school.faang.spotify_block;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {

    final Object lock = new Object();
    Boolean isPlaying = true;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                log.info("Play music");
            } else {
                log.info("Music is already playing ");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("Paused music");
            } else {
                log.info("Music is not playing ");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("Skipping track");
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("Playing previous track");
        }

    }

}
