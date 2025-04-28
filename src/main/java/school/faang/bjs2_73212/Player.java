package school.faang.bjs2_73212;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Player extends Thread {

    private boolean isPlaying;
    private final Lock lock = new ReentrantLock();

    public void play() {
        lock.lock();
        try {
            if (isPlaying) {
                System.out.println("Music is already playing");
            }
            System.out.println("Music plays");
            isPlaying = true;
        } finally {
            lock.unlock();
        }
    }

    public void pause() {
        lock.lock();
        try {
            if (isPlaying) {
                System.out.println("Music pauses");
                isPlaying = false;
            } else {
                System.out.println("Music is not playing");
            }

        } finally {
            lock.unlock();
        }
    }

    public synchronized void skip() {
        lock.lock();
        try {
            System.out.println("Song skipped");
        } finally {
            lock.unlock();
        }
    }

    public synchronized void previous() {
        lock.lock();
        try {
            System.out.println("Previous song");
        } finally {
            lock.unlock();
        }
    }
}
