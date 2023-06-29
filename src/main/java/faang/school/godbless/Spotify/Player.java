package faang.school.godbless.Spotify;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Player {
    private final Lock lock = new ReentrantLock();
    private volatile boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            System.out.println("play");
            isPlaying = true;
        }
    }

    public void pause() {
        synchronized (lock) {
            System.out.println("pause");
            isPlaying = false;
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("skip");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("previous");
        }
    }
}
