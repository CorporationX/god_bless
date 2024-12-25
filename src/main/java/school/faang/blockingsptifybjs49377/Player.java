package school.faang.blockingsptifybjs49377;

import java.util.Objects;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Music is now playing");
            } else {
                System.out.println("Music is already playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Music is paused");
            } else {
                System.out.println("Music is already paused");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Skipped to the next track");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Returned to previous track");
        }
    }
}
