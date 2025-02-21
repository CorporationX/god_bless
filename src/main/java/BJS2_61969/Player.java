package BJS2_61969;

import lombok.Getter;

@Getter
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Already playing");
            } else {
                isPlaying = true;
                System.out.println("Playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Paused");
            } else {
                System.out.println("Already paused");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Previous");
        }
    }
}
