package faang.school.godbless.spotify.blocking;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Player {
    private final String lock = "lock";
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                try {
                    System.out.println("The track has started playing");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("Playing music");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("The music is still playing");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("The track just has finished");
                    isPlaying = true;
                } catch (InterruptedException exception) {
                    log.error("Thread was interrupted after play button was pressed", exception);
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                try {
                    System.out.println("Music on pause");
                    TimeUnit.SECONDS.sleep(3);
                    isPlaying = false;
                } catch (InterruptedException exception) {
                    log.error("Thread was interrupted after pause button was pressed", exception);
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            try {
                System.out.println("Skipping to next track");
                TimeUnit.SECONDS.sleep(3);
                isPlaying = true;
            } catch (InterruptedException exception) {
                log.error("Thread was interrupted after skip button was pressed", exception);
                Thread.currentThread().interrupt();
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            try {
                System.out.println("Going back to previous track");
                TimeUnit.SECONDS.sleep(3);
                isPlaying = true;
            } catch (InterruptedException exception) {
                log.error("Thread was interrupted after previous button was pressed", exception);
                Thread.currentThread().interrupt();
            }
        }
    }
}
