package school.faang.spotify;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Player {

    private final Lock lock = new ReentrantLock();
    private boolean isPlaying;
    private int currentTrack;

    public Player() {
        this.isPlaying = false;
        this.currentTrack = 0;
    }

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("Playing track: " + currentTrack);
                isPlaying = true;
            } else {
                System.out.println("Music is already playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Music was stopped:" + currentTrack);
                isPlaying = false;
            } else {
                System.out.println("Music was not playing");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            if (isPlaying) {
                currentTrack++;
                System.out.println("Skipping to track: " + currentTrack);
            } else {
                System.out.println("Cannot skip when pause!");
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            if (isPlaying) {
                if (currentTrack > 0) {
                    currentTrack--;
                    System.out.println("Returning to track:" + currentTrack);
                } else {
                    System.out.println("This is the first track");
                }
            } else {
                System.out.println("Cannot go back while music is paused.");
            }
        }
    }
}
