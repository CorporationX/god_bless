package faang.school.godbless.spotify;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Player {
    private boolean isPlaying=false;
    private final Lock lock = new ReentrantLock();

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("Playing music");
                isPlaying = true;
            } else {
                System.out.println("Music is already playing ");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Pause music");
                isPlaying = false;
            } else {
                System.out.println("Music is already paused ");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Skipping to the next music");
            } else {
                System.out.println("Cannot skip, music is paused");
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Go to previous music");
            } else {
                System.out.println("Cannot go back, music is paused ");
            }
        }
    }
}
