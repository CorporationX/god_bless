package bjs2_35746;

import lombok.Getter;


public class Player {
    private final Object lock = new Object();
    @Getter
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            System.out.println("Playing track");
            isPlaying = true;
        }
    }

    public void pause() {
        synchronized (lock) {
            System.out.println("Track paused");
            isPlaying = false;
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Skipped track");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Returned to previous track");
        }
    }
}
