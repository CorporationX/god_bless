package spotify_block;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Player {
    private final Lock lock = new ReentrantLock();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Playing");
            lock.notifyAll();
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Pause");
            lock.notifyAll();
        }

    }

    public void skip() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Skipping");
            lock.notifyAll();
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Previous");
            lock.notifyAll();
        }
    }
}
