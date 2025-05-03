package school.faang.spotify.spotify;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Player {
    private final Lock lock = new ReentrantLock();
    private boolean isPlaying = false;

    public void play() {
        lock.lock();
        try {
            if (!isPlaying) {
                System.out.println("Music is now playing.");
                isPlaying = true;
            } else {
                System.out.println("Music is already playing.");
            }
        } finally {
            lock.unlock();
        }
    }

    public void pause() {
        lock.lock();
        try {
            if (isPlaying) {
                System.out.println("Music is paused.");
                isPlaying = false;
            } else {
                System.out.println("Music is already paused.");
            }
        } finally {
            lock.unlock();
        }
    }

    public void skip() {
        lock.lock();
        try {
            System.out.println("Skipped to the next track.");

        } finally {
            lock.unlock();
        }
    }

    public void previous() {
        lock.lock();
        try {
            System.out.println("Returned to the previous track.");

        } finally {
            lock.unlock();
        }
    }
}