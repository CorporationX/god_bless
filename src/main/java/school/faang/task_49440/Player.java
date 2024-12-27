package school.faang.task_49440;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlay = false;
    private int currentTrack = 0;
    private final String[] playlist = {"Track 1", "Track 2", "Track 3", "Track 4"};


    public void play() {
        synchronized (lock) {
            if (!isPlay) {
                isPlay = true;
                log.info("Playing: {}", playlist[currentTrack]);
            } else {
                log.info("Already playing: {}", playlist[currentTrack]);
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlay) {
                isPlay = false;
                log.info("Paused: {}", playlist[currentTrack]);
            } else {
                log.info("Already paused: {}", playlist[currentTrack]);
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            currentTrack = (currentTrack + 1) % playlist.length;
            log.info("Skipping to: {}", playlist[currentTrack]);
        }
    }

    public void previous() {
        synchronized (lock) {
            currentTrack = (currentTrack - 1 + playlist.length) % playlist.length;
            log.info("Going back to: {}", playlist[currentTrack]);
        }
    }
}
