package school.faang.bjs2_73172;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final String lock;
    private boolean isPlaying;

    public Player(String lock) {
        this.lock = lock;
        this.isPlaying = false;
    }

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                log.info("Music already on");
            } else {
                isPlaying = true;
                log.info("Music on");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("Music off");
            } else {
                log.info("Music already on pause");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = true;
            log.info("Skip music");
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = false;
            log.info("Previous music");
        }
    }
}
