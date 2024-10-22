package school.faang.blockingspotify;

import lombok.Getter;

public class Player {
    private final Object lock = new Object();
    @Getter
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Music is now playing.");
            } else {
                System.out.println("Music is already playing.");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Music is now paused.");
            } else {
                System.out.println("Music is already paused.");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Skipping to the next track.");
            } else {
                System.out.println("Can't skip. Music is paused.");
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Going back to the previous track.");
            } else {
                System.out.println("Can't go back. Music is paused.");
            }
        }
    }
}

