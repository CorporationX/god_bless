package school.faang.module3.spotify;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private boolean isPlaying;

    public void play() {
        synchronized (this) {
            isPlaying = true;
            log.info("Music starts playing");
            printCurrentTrackState();
            imitateAction();
        }
    }

    public void pause() {
        synchronized (this) {
            isPlaying = false;
            log.info("Music was paused");
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
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void printCurrentTrackState() {
        log.info("music state: {}", isPlaying);
    }
}
