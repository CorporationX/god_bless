package school.faang.module3.spotify;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private static final long TIME_FOR_ACTION_MS = 2000;
    private boolean isPlaying;

    public void play() {
        synchronized (this) {
            if (isPlaying) {
                log.info("Music was already playing");
            } else {
                isPlaying = true;
                log.info("Music starts playing");
            }
            printCurrentTrackState();
            imitateAction();
        }
    }

    public void pause() {
        synchronized (this) {
            if (!isPlaying) {
                log.info("Music was already stopped");
            } else {
                isPlaying = false;
                log.info("Music was paused");
            }
            printCurrentTrackState();
            imitateAction();
        }
    }

    public void skip() {
        synchronized (this) {
            log.info("Track skipped");
            printCurrentTrackState();
            imitateAction();
        }
    }

    public void previous() {
        synchronized (this) {
            log.info("Selected previous track");
            printCurrentTrackState();
            imitateAction();
        }
    }

    private void imitateAction() {
        try {
            Thread.sleep(TIME_FOR_ACTION_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void printCurrentTrackState() {
        log.info("music state: {}", isPlaying);
    }
}
